package in.siddhant.anetpays_customer.POJO;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;

import in.siddhant.anetpays_customer.R;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder>{
    private Context context;
    private List<Transactions.Associate> TransactionsList;
    private List<Transactions.Datum> TransactionDate;

    public TransactionsAdapter(Context context, List<Transactions.Associate> TransactionsList, List<Transactions.Datum> TransactionDate){
        this.context = context;
        this.TransactionsList = TransactionsList;
        this.TransactionDate = TransactionDate;
    }

    public void setTransactionsList(List<Transactions.Associate> transactionsList, List<Transactions.Datum> transactionDate){
        this.TransactionsList = transactionsList;
        this.TransactionDate = transactionDate;
        notifyDataSetChanged();
    }

    @Override
    public TransactionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_transactions, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionsAdapter.MyViewHolder holder, int position) {
        holder.associateName.setText(TransactionsList.get(position).getName());
        holder.transactionDate.setText(TransactionDate.get(position).getTransactionDate());
        int value = (int)toASCI(TransactionsList.get(position).getName());
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
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView associateName;
        TextView transactionDate;
        MaterialLetterIcon materialLetterIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            associateName = (TextView)itemView.findViewById(R.id.nameAssociate);
            transactionDate = (TextView)itemView.findViewById(R.id.dateTransaction);
            materialLetterIcon = (MaterialLetterIcon)itemView.findViewById(R.id.icon);
        }
    }
}
