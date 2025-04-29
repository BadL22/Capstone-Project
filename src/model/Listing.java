package model;

public class Listing {
    private String title;
    private double price;
    private String category;
    private String farmer;

    public Listing(String title, double price, String category, String farmer) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.farmer = farmer;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getFarmer() {
        return farmer;
    }
}
