package es.logixs.domain;

public class Sales {

    private String id;
    private String ownerId;
    private String clientId;
    private String code;
    private String offerId;
    private String counterOfferId;
    private boolean isCounterOffer;

    
    public Sales() {
    }

    
    public Sales(String id, String ownerId, String clientId, String code, String offerId, String counterOfferId,
            boolean isCounterOffer) {
        this.id = id;
        this.ownerId = ownerId;
        this.clientId = clientId;
        this.code = code;
        this.offerId = offerId;
        this.counterOfferId = counterOfferId;
        this.isCounterOffer = isCounterOffer;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getOfferId() {
        return offerId;
    }
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
    public String getCounterOfferId() {
        return counterOfferId;
    }
    public void setCounterOfferId(String counterOfferId) {
        this.counterOfferId = counterOfferId;
    }
    public boolean isCounterOffer() {
        return isCounterOffer;
    }
    public void setCounterOffer(boolean isCounterOffer) {
        this.isCounterOffer = isCounterOffer;
    }
    
}
