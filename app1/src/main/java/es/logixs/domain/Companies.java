package es.logixs.domain;

public class Companies {
    private String objectid;
    private String code;
    private String licenseId;
    private String name;
    private String taxId;

    public Companies(String objectid, String code, String licenseId, String name, String taxId) {
        this.objectid = objectid;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public Companies(String objectid) {
        this.objectid = objectid;
    }

    public Companies(String code, String licenseId, String name, String taxId) {
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
