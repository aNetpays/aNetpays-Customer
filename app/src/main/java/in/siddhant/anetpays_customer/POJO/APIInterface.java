package in.siddhant.anetpays_customer.POJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/aNet/rest/users/{user_id}")
    Call<User> getUserList(@Path(value = "user_id", encoded = true) String user_id);

    @GET("/aNet/rest/users/{user_id}/transactions")
    Call<Transactions.Associate>getTransactionList(@Path(value = "user_id",encoded = true)String user_id);

    @GET("/aNet/rest/users/{user_id}/transactions")
    Call<Transactions.Datum>getTransactionDatum(@Path(value = "user_id",encoded = true)String user_id);
}
