package in.siddhant.anetpays_customer.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordReset {

    @SerializedName("data")
    private String data;
    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("status")
    private String status;
 /*   @Expose
    private String data;
    @Expose
    private String status_code;
    @Expose
    private String status;*/

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
