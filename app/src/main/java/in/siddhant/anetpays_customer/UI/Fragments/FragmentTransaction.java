package in.siddhant.anetpays_customer.UI.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import in.siddhant.anetpays_customer.POJO.APIClient;
import in.siddhant.anetpays_customer.POJO.APIInterface;
import in.siddhant.anetpays_customer.POJO.Transactions;
import in.siddhant.anetpays_customer.POJO.TransactionsAdapter;
import in.siddhant.anetpays_customer.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.PREF_LOGIN;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.UNIQUE_ID;

public class FragmentTransaction extends Fragment {

    List<Transactions.Associate> TransactionAssociate;
    List<Transactions.Datum> TransactionDatum;
    RecyclerView recyclerView;
    TransactionsAdapter transactionsAdapter;
    private static SharedPreferences sharedPreferences;
    private View view;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        view = layoutInflater.inflate(R.layout.fragment_transactions, viewGroup, false);
        sharedPreferences = getActivity().getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        TransactionAssociate = new ArrayList<>();
        TransactionDatum = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        transactionsAdapter = new TransactionsAdapter(getContext(), TransactionAssociate, TransactionDatum);
        recyclerView.setAdapter(transactionsAdapter);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Transactions.Associate> call = apiInterface.getTransactionList(sharedPreferences.getString(UNIQUE_ID, "qwe"));
        call.enqueue(new Callback<Transactions.Associate>() {
            @Override
            public void onResponse(Call<Transactions.Associate> call, Response<Transactions.Associate> response) {
                TransactionAssociate = response.body();
            }

            @Override
            public void onFailure(Call<Transactions.Associate> call, Throwable t) {

            }
        });

        return view;
    }
}
