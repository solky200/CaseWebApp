package model;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private String color;
    private double price;
    private String urlImage;

    public Phone(int id, String name, String brand, String color, double price, String urlImage) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.urlImage = urlImage;
    }

    public Phone(String name, String brand, String color, double price, String urlImage) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.urlImage = urlImage;
    }

    public Phone() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
