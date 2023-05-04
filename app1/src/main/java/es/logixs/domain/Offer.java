package es.logixs.domain;

import java.util.Objects;

public class Offer {

    private int id;
    private String code;
    private String name;
    private String description;
    private String category;

//        private int productId;
//
//        private int ownerId;
//
//        private int companyId;

    public Offer(int id, String code, String name, String description, String category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Offer(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offers)) return false;
        return id == offers.id && Objects.equals(code, offers.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
