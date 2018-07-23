package in.siddhant.anetpays_customer.POJO;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;

import in.siddhant.anetpays_customer.R;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder>{
    private Context context;
    private List <Transactions.DataEntity> TransactionsList;

    public TransactionsAdapter(Context context, List<Transactions.DataEntity> TransactionsList) {
        this.context = context;
        this.TransactionsList = TransactionsList;
    }

    public void setTransactionsList(List<Transactions.DataEntity> transactionsList){
        this.TransactionsList = transactionsList;

        notifyDataSetChanged();
    }

    @Override
    public TransactionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_transactions, parent, false);
        Log.d("1", "Loaded View Adapter");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionsAdapter.MyViewHolder holder, int position) {

        Transactions.DataEntity dataEntity = TransactionsList.get(position);

        holder.associateName.setText(dataEntity.getAssociate().getName());
        holder.transactionDate.setText(dataEntity.getTransactionDate());
        holder.transactionID.setText(dataEntity.getTransactionId());

        Log.d("2", "BindViewHolder "+position);

        int value = (int)toASCI(dataEntity.getAssociate().getName());
        holder.materialLetterIcon = new MaterialLetterIcon.Builder(context)
                .shapeColor(R.color.background_color)
                .initials(true)
                .initialsNumber(1)
                .lettersNumber(value)
                .shapeType(MaterialLetterIcon.Shape.CIRCLE)
                .create();
    }
    private static long toASCI(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String asciiString = null;
        long ASCIint;
        for (int i = 1; i <= 1; i++){
            stringBuilder.append((int)s.charAt(i));
            char c = s.charAt(i);
        }
        asciiString = stringBuilder.toString();
        ASCIint = Long.parseLong(asciiString);
        return ASCIint;
    }

    @Override
    public int getItemCount() {
        if (TransactionsList != null)
        {
            return TransactionsList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView associateName;
        TextView transactionDate;
        TextView transactionID;
        MaterialLetterIcon materialLetterIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            associateName = (TextView) itemView.findViewById(R.id.nameAssociate);
            transactionDate = (TextView) itemView.findViewById(R.id.dateTransaction);
            transactionID = (TextView) itemView.findViewById(R.id.TransactionID);
            materialLetterIcon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
        }
    }
}
