package es.logixs.domain;

public class User {

    private String objectid;
    private String name;
    private String lastName;
    private String email;
    public String getObjectid() {
        return objectid;
    }
    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(String objectid) {
        this.objectid = objectid;
    }
    public User(String objectid, String name, String lastName, String email) {
        this.objectid = objectid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }



}
