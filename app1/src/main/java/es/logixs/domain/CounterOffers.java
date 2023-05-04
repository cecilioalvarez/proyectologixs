package es.logixs.domain;



public class CounterOffers {
    private int id;
    private String name;
    private String vom;
    private double originalPrice;
    private double counterOfferPrice;
    private double quantity;

    public CounterOffers() {

    }

    public CounterOffers(int id, String name, String vom, double originalPrice, double counterOfferPrice, double quantity) {
        this.id = id;
        this.name = name;
        this.vom = vom;
        this.originalPrice = originalPrice;
        this.counterOfferPrice = counterOfferPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVom() {
        return vom;
    }

    public void setVom(String vom) {
        this.vom = vom;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getCounterOfferPrice() {
        return counterOfferPrice;
    }

    public void setCounterOfferPrice(double counterOfferPrice) {
        this.counterOfferPrice = counterOfferPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
