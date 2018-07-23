package in.siddhant.anetpays_customer.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleTransaction {


    @SerializedName("data")
    private List<DataEntity> data;
    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("status")
    private String status;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
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

    public static class DataEntity {
        @SerializedName("card")
        private CardEntity card;
        @SerializedName("card_id")
        private String cardId;
        @SerializedName("associate")
        private AssociateEntity associate;
        @SerializedName("associate_id")
        private String associateId;
        @SerializedName("currency")
        private String currency;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("amount")
        private String amount;
        @SerializedName("transaction_date")
        private String transactionDate;
        @SerializedName("transaction_id")
        private String transactionId;

        public CardEntity getCard() {
            return card;
        }

        public void setCard(CardEntity card) {
            this.card = card;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public AssociateEntity getAssociate() {
            return associate;
        }

        public void setAssociate(AssociateEntity associate) {
            this.associate = associate;
        }

        public String getAssociateId() {
            return associateId;
        }

        public void setAssociateId(String associateId) {
            this.associateId = associateId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }
    }

    public static class CardEntity {
        @SerializedName("holder_name")
        private String holderName;
        @SerializedName("last_update_date")
        private String lastUpdateDate;
        @SerializedName("brand")
        private String brand;
        @SerializedName("created_date")
        private String createdDate;
        @SerializedName("bank_name")
        private String bankName;
        @SerializedName("expiration_month")
        private String expirationMonth;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("expiration_year")
        private String expirationYear;
        @SerializedName("card_id")
        private String cardId;
        @SerializedName("type")
        private String type;
        @SerializedName("openpay_card_id")
        private String openpayCardId;
        @SerializedName("card_number")
        private String cardNumber;
        @SerializedName("allows_charges")
        private String allowsCharges;
        @SerializedName("is_active")
        private String isActive;
        @SerializedName("bank_code")
        private String bankCode;

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public String getLastUpdateDate() {
            return lastUpdateDate;
        }

        public void setLastUpdateDate(String lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getExpirationMonth() {
            return expirationMonth;
        }

        public void setExpirationMonth(String expirationMonth) {
            this.expirationMonth = expirationMonth;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getExpirationYear() {
            return expirationYear;
        }

        public void setExpirationYear(String expirationYear) {
            this.expirationYear = expirationYear;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOpenpayCardId() {
            return openpayCardId;
        }

        public void setOpenpayCardId(String openpayCardId) {
            this.openpayCardId = openpayCardId;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getAllowsCharges() {
            return allowsCharges;
        }

        public void setAllowsCharges(String allowsCharges) {
            this.allowsCharges = allowsCharges;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }
    }

    public static class AssociateEntity {
        @SerializedName("last_update_date")
        private String lastUpdateDate;
        @SerializedName("associate_id")
        private String associateId;
        @SerializedName("created_date")
        private String createdDate;
        @SerializedName("name")
        private String name;
        @SerializedName("associate_type")
        private String associateType;
        @SerializedName("is_active")
        private String isActive;

        public String getLastUpdateDate() {
            return lastUpdateDate;
        }

        public void setLastUpdateDate(String lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
        }

        public String getAssociateId() {
            return associateId;
        }

        public void setAssociateId(String associateId) {
            this.associateId = associateId;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAssociateType() {
            return associateType;
        }

        public void setAssociateType(String associateType) {
            this.associateType = associateType;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }
    }
}
