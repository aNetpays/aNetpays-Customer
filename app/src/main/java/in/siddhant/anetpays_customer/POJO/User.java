
package in.siddhant.anetpays_customer.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class User {

    @SerializedName("data")
    private List<UserData> mData;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("status_code")
    private String mStatusCode;

    public List<UserData> getData() {
        return mData;
    }

    public void setData(List<UserData> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(String statusCode) {
        mStatusCode = statusCode;
    }

    public class UserData {

        @SerializedName("cell_phone")
        private String mCellPhone;
        @SerializedName("created_date")
        private String mCreatedDate;
        @SerializedName("dob_day")
        private String mDobDay;
        @SerializedName("dob_month")
        private String mDobMonth;
        @SerializedName("dob_year")
        private String mDobYear;
        @SerializedName("facebook_name")
        private Object mFacebookName;
        @SerializedName("google_name")
        private Object mGoogleName;
        @SerializedName("is_active")
        private String mIsActive;
        @SerializedName("is_logged_in")
        private String mIsLoggedIn;
        @SerializedName("last_login_date")
        private String mLastLoginDate;
        @SerializedName("last_name_1")
        private String mLastName1;
        @SerializedName("last_name_2")
        private String mLastName2;
        @SerializedName("last_update_date")
        private String mLastUpdateDate;
        @SerializedName("names")
        private String mNames;
        @SerializedName("openpay_client_id")
        private String mOpenpayClientId;
        @SerializedName("password")
        private String mPassword;
        @SerializedName("profile_pic_uri")
        private Object mProfilePicUri;
        @SerializedName("token")
        private Object mToken;
        @SerializedName("token_exp_date")
        private Object mTokenExpDate;
        @SerializedName("user_email")
        private String mUserEmail;
        @SerializedName("user_id")
        private String mUserId;

        public String getCellPhone() {
            return mCellPhone;
        }

        public void setCellPhone(String cellPhone) {
            mCellPhone = cellPhone;
        }

        public String getCreatedDate() {
            return mCreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            mCreatedDate = createdDate;
        }

        public String getDobDay() {
            return mDobDay;
        }

        public void setDobDay(String dobDay) {
            mDobDay = dobDay;
        }

        public String getDobMonth() {
            return mDobMonth;
        }

        public void setDobMonth(String dobMonth) {
            mDobMonth = dobMonth;
        }

        public String getDobYear() {
            return mDobYear;
        }

        public void setDobYear(String dobYear) {
            mDobYear = dobYear;
        }

        public Object getFacebookName() {
            return mFacebookName;
        }

        public void setFacebookName(Object facebookName) {
            mFacebookName = facebookName;
        }

        public Object getGoogleName() {
            return mGoogleName;
        }

        public void setGoogleName(Object googleName) {
            mGoogleName = googleName;
        }

        public String getIsActive() {
            return mIsActive;
        }

        public void setIsActive(String isActive) {
            mIsActive = isActive;
        }

        public String getIsLoggedIn() {
            return mIsLoggedIn;
        }

        public void setIsLoggedIn(String isLoggedIn) {
            mIsLoggedIn = isLoggedIn;
        }

        public String getLastLoginDate() {
            return mLastLoginDate;
        }

        public void setLastLoginDate(String lastLoginDate) {
            mLastLoginDate = lastLoginDate;
        }

        public String getLastName1() {
            return mLastName1;
        }

        public void setLastName1(String lastName1) {
            mLastName1 = lastName1;
        }

        public String getLastName2() {
            return mLastName2;
        }

        public void setLastName2(String lastName2) {
            mLastName2 = lastName2;
        }

        public String getLastUpdateDate() {
            return mLastUpdateDate;
        }

        public void setLastUpdateDate(String lastUpdateDate) {
            mLastUpdateDate = lastUpdateDate;
        }

        public String getNames() {
            return mNames;
        }

        public void setNames(String names) {
            mNames = names;
        }

        public String getOpenpayClientId() {
            return mOpenpayClientId;
        }

        public void setOpenpayClientId(String openpayClientId) {
            mOpenpayClientId = openpayClientId;
        }

        public String getPassword() {
            return mPassword;
        }

        public void setPassword(String password) {
            mPassword = password;
        }

        public Object getProfilePicUri() {
            return mProfilePicUri;
        }

        public void setProfilePicUri(Object profilePicUri) {
            mProfilePicUri = profilePicUri;
        }

        public Object getToken() {
            return mToken;
        }

        public void setToken(Object token) {
            mToken = token;
        }

        public Object getTokenExpDate() {
            return mTokenExpDate;
        }

        public void setTokenExpDate(Object tokenExpDate) {
            mTokenExpDate = tokenExpDate;
        }

        public String getUserEmail() {
            return mUserEmail;
        }

        public void setUserEmail(String userEmail) {
            mUserEmail = userEmail;
        }

        public String getUserId() {
            return mUserId;
        }

        public void setUserId(String userId) {
            mUserId = userId;
        }

    }


}
