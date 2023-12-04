package data.models;

public class Product {
    private String name;
    private String description;
    private String type;
    private String price;

    public Product(String name, String description, String type, String price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return this.name + "," + this.description + "," + this.type + "," + this.price;
    }
}