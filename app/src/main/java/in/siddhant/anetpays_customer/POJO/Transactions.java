
package in.siddhant.anetpays_customer.POJO;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Transactions{

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("status_code")
    private String mStatusCode;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
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

    public class Datum {

        @SerializedName("amount")
        private String mAmount;
        @SerializedName("associate")
        private Associate mAssociate;
        @SerializedName("associate_id")
        private String mAssociateId;
        @SerializedName("card")
        private Card mCard;
        @SerializedName("card_id")
        private String mCardId;
        @SerializedName("currency")
        private String mCurrency;
        @SerializedName("transaction_date")
        private String mTransactionDate;
        @SerializedName("transaction_id")
        private String mTransactionId;
        @SerializedName("user_id")
        private String mUserId;

        public String getAmount() {
            return mAmount;
        }

        public void setAmount(String amount) {
            mAmount = amount;
        }

        public Associate getAssociate() {
            return mAssociate;
        }

        public void setAssociate(Associate associate) {
            mAssociate = associate;
        }

        public String getAssociateId() {
            return mAssociateId;
        }

        public void setAssociateId(String associateId) {
            mAssociateId = associateId;
        }

        public Card getCard() {
            return mCard;
        }

        public void setCard(Card card) {
            mCard = card;
        }

        public String getCardId() {
            return mCardId;
        }

        public void setCardId(String cardId) {
            mCardId = cardId;
        }

        public String getCurrency() {
            return mCurrency;
        }

        public void setCurrency(String currency) {
            mCurrency = currency;
        }

        public String getTransactionDate() {
            return mTransactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            mTransactionDate = transactionDate;
        }

        public String getTransactionId() {
            return mTransactionId;
        }

        public void setTransactionId(String transactionId) {
            mTransactionId = transactionId;
        }

        public String getUserId() {
            return mUserId;
        }

        public void setUserId(String userId) {
            mUserId = userId;
        }

    }

    public class Associate {

        @SerializedName("associate_id")
        private String mAssociateId;
        @SerializedName("associate_type")
        private String mAssociateType;
        @SerializedName("created_date")
        private String mCreatedDate;
        @SerializedName("is_active")
        private String mIsActive;
        @SerializedName("last_update_date")
        private String mLastUpdateDate;
        @SerializedName("name")
        private String mName;
        @SerializedName("url")
        private Object mUrl;

        public String getAssociateId() {
            return mAssociateId;
        }

        public void setAssociateId(String associateId) {
            mAssociateId = associateId;
        }

        public String getAssociateType() {
            return mAssociateType;
        }

        public void setAssociateType(String associateType) {
            mAssociateType = associateType;
        }

        public String getCreatedDate() {
            return mCreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            mCreatedDate = createdDate;
        }

        public String getIsActive() {
            return mIsActive;
        }

        public void setIsActive(String isActive) {
            mIsActive = isActive;
        }

        public String getLastUpdateDate() {
            return mLastUpdateDate;
        }

        public void setLastUpdateDate(String lastUpdateDate) {
            mLastUpdateDate = lastUpdateDate;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public Object getUrl() {
            return mUrl;
        }

        public void setUrl(Object url) {
            mUrl = url;
        }

    }

    public class Card {

        @SerializedName("allows_charges")
        private String mAllowsCharges;
        @SerializedName("bank_code")
        private String mBankCode;
        @SerializedName("bank_name")
        private String mBankName;
        @SerializedName("brand")
        private String mBrand;
        @SerializedName("card_id")
        private String mCardId;
        @SerializedName("card_number")
        private String mCardNumber;
        @SerializedName("created_date")
        private String mCreatedDate;
        @SerializedName("expiration_month")
        private String mExpirationMonth;
        @SerializedName("expiration_year")
        private String mExpirationYear;
        @SerializedName("holder_name")
        private String mHolderName;
        @SerializedName("is_active")
        private String mIsActive;
        @SerializedName("last_update_date")
        private String mLastUpdateDate;
        @SerializedName("openpay_card_id")
        private String mOpenpayCardId;
        @SerializedName("type")
        private String mType;
        @SerializedName("user_id")
        private String mUserId;

        public String getAllowsCharges() {
            return mAllowsCharges;
        }

        public void setAllowsCharges(String allowsCharges) {
            mAllowsCharges = allowsCharges;
        }

        public String getBankCode() {
            return mBankCode;
        }

        public void setBankCode(String bankCode) {
            mBankCode = bankCode;
        }

        public String getBankName() {
            return mBankName;
        }

        public void setBankName(String bankName) {
            mBankName = bankName;
        }

        public String getBrand() {
            return mBrand;
        }

        public void setBrand(String brand) {
            mBrand = brand;
        }

        public String getCardId() {
            return mCardId;
        }

        public void setCardId(String cardId) {
            mCardId = cardId;
        }

        public String getCardNumber() {
            return mCardNumber;
        }

        public void setCardNumber(String cardNumber) {
            mCardNumber = cardNumber;
        }

        public String getCreatedDate() {
            return mCreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            mCreatedDate = createdDate;
        }

        public String getExpirationMonth() {
            return mExpirationMonth;
        }

        public void setExpirationMonth(String expirationMonth) {
            mExpirationMonth = expirationMonth;
        }

        public String getExpirationYear() {
            return mExpirationYear;
        }

        public void setExpirationYear(String expirationYear) {
            mExpirationYear = expirationYear;
        }

        public String getHolderName() {
            return mHolderName;
        }

        public void setHolderName(String holderName) {
            mHolderName = holderName;
        }

        public String getIsActive() {
            return mIsActive;
        }

        public void setIsActive(String isActive) {
            mIsActive = isActive;
        }

        public String getLastUpdateDate() {
            return mLastUpdateDate;
        }

        public void setLastUpdateDate(String lastUpdateDate) {
            mLastUpdateDate = lastUpdateDate;
        }

        public String getOpenpayCardId() {
            return mOpenpayCardId;
        }

        public void setOpenpayCardId(String openpayCardId) {
            mOpenpayCardId = openpayCardId;
        }

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public String getUserId() {
            return mUserId;
        }

        public void setUserId(String userId) {
            mUserId = userId;
        }

    }
}
