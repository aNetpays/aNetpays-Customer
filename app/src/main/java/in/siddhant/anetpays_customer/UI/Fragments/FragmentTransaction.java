package in.siddhant.anetpays_customer.UI.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import in.siddhant.anetpays_customer.POJO.APIClient;
import in.siddhant.anetpays_customer.POJO.APIInterface;
import in.siddhant.anetpays_customer.POJO.SingleTransaction;
import in.siddhant.anetpays_customer.POJO.Transactions;
import in.siddhant.anetpays_customer.POJO.TransactionsAdapter;
import in.siddhant.anetpays_customer.R;
import in.siddhant.anetpays_customer.Utils.RecyclerItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.PREF_LOGIN;
import static in.siddhant.anetpays_customer.ProfileConstants.SharedConstants.UNIQUE_ID;

public class FragmentTransaction extends Fragment {

    RecyclerView recyclerView;
    TransactionsAdapter transactionsAdapter;
    private ArrayList<Transactions.DataEntity> listItems = new ArrayList<>();
    private static SharedPreferences sharedPreferences;
    private View view;
    private static ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = layoutInflater.inflate(R.layout.fragment_transactions, viewGroup, false);
        progressDialog = new ProgressDialog(getActivity());
        sharedPreferences = getActivity().getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        transactionsAdapter = new TransactionsAdapter(getContext(), listItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("1", "Clicked");
                showDialog();
                    final Transactions.DataEntity transactions = listItems.get(position);
                    String transactionID = transactions.getTransactionId();
                    String id = sharedPreferences.getString(UNIQUE_ID, "qwe");

                    MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                            .title(R.string.TransactionDetails)
                            .customView(R.layout.dialog_transaction_single, true)
                            .positiveText(R.string.activity_dialog_accept)
                            .build();

                    TextView BusinessName, TransactionDate, TransactionAmount, CardNumber, CardHolder, CardType;
                    BusinessName = dialog.getCustomView().findViewById(R.id.businessName);
                    TransactionDate = dialog.getCustomView().findViewById(R.id.transactionDate);
                    TransactionAmount = dialog.getCustomView().findViewById(R.id.transactionAmount);
                    CardNumber = dialog.getCustomView().findViewById(R.id.cardNumber);
                    CardHolder = dialog.getCustomView().findViewById(R.id.cardHolder);
                    CardType = dialog.getCustomView().findViewById(R.id.CardType);


                    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<SingleTransaction> call = apiInterface.getTransaction(id, transactionID);
                    call.enqueue(new Callback<SingleTransaction>() {
                        @Override
                        public void onResponse(Call<SingleTransaction> call, Response<SingleTransaction> response) {
                            SingleTransaction singleTransaction = response.body();
                            List<SingleTransaction.DataEntity> dataEntities = singleTransaction.getData();
                            for (SingleTransaction.DataEntity dataEntity : dataEntities) {
                                String Name = dataEntity.getAssociate().getName();
                                String Date = dataEntity.getTransactionDate();
                                String Amount = dataEntity.getAmount();
                                String CardNum = dataEntity.getCard().getCardNumber();
                                String CardHold = dataEntity.getCard().getHolderName();
                                String CardT = dataEntity.getCard().getType();
                                BusinessName.setText(Name);
                                TransactionDate.setText(Date);
                                TransactionAmount.setText(Amount);
                                CardNumber.setText(CardNum);
                                CardHolder.setText(CardHold);
                                CardType.setText(CardT);

                            }

                        }

                        @Override
                        public void onFailure(Call<SingleTransaction> call, Throwable t) {

                        }
                    });
                    dialog.show();
                    hideDialog();
            }
        }));

        recyclerView.setAdapter(transactionsAdapter);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Transactions> call = apiInterface.getTransactionList(sharedPreferences.getString(UNIQUE_ID, "qwe"));
        call.enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {

                listItems.addAll(response.body().getData());
                Log.d("5", "Passing to Adapter");
                try {
                    transactionsAdapter.setTransactionsList(listItems);
                    Log.d("4", "Passed to Adapter");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {
                Log.d("6", "Passing to Adapter Failure", t);
            }
        });

        return view;


    }


    private void hideDialog() {
        if (progressDialog.isShowing())
        {
            progressDialog.hide();
        }
    }

    private void showDialog(){
        if (!progressDialog.isShowing())
        {
            progressDialog.show();
        }
    }

}

