package in.siddhant.anetpays_customer.POJO;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("updated_rows")
    private String updatedRows;
    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("status")
    private String status;

    public String getUpdatedRows() {
        return updatedRows;
    }

    public void setUpdatedRows(String updatedRows) {
        this.updatedRows = updatedRows;
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
