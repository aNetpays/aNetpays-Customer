package in.siddhant.anetpays_customer.POJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/aNet/rest/users/{user_id}")
    Call<User> getUserList(@Path(value = "user_id", encoded = true) String user_id);

    @GET("/aNet/rest/users/{user_id}/transactions")
    Call<Transactions>getTransactionList(@Path(value = "user_id",encoded = true)String user_id);

    @GET("/aNet/rest/users/{user_id}/transactions/{transaction_id}")
    Call<SingleTransaction>getTransaction(@Path(value = "user_id", encoded = true)String user_id, @Path(value = "transaction_id", encoded = true)String transaction_id);

    @FormUrlEncoded
    @POST("/aNet/rest/users/")
    Call<UserResponse>LoginAttempt(@Field("user_email") String user_email, @Field("last_name_1")String last_name_1,
                                   @Field("last_name_2") String last_name_2, @Field("names") String names, @Field("dob_day") String dob_day,
                                   @Field("dob_month") String dob_month, @Field("dob_year") String dob_year, @Field("cellphone") String cellphone,
                                   @Field("password") String password );

    @FormUrlEncoded
    @POST("/aNet/rest/users/pwdresetrequest")
    Call<PasswordReset>Reset(@Field("email")String email);
}
