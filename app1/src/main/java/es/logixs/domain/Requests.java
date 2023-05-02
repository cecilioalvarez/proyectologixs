package es.logixs.domain;

public class Requests {
    private String id;
    private String code;
    private String offerId;
    private String ownerId;
    private String companyID;


    public Requests(String code, String offerId, String ownerId, String companyID) {
        this.code = code;
        this.offerId = offerId;
        this.ownerId = ownerId;
        this.companyID = companyID;
    }

    public Requests(String id) {
        this.id = id;
    }

    public Requests() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
}
