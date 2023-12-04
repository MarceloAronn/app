package data;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import data.models.Product;

public class ProductManager {
    private String pathFileProduct;
    private ArrayList<Product> products;
    public ProductManager(String pathFileProduct) {
        this.pathFileProduct = pathFileProduct;
        this.products = new ArrayList<>();
    }
    public String getPathDirectory() {
        return pathFileProduct;
    }
    public void setPathDirectory(String pathDirectory) {
        this.pathFileProduct = pathDirectory;
    }
    public ArrayList<Product> getproducts() {
        this.products = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(this.pathFileProduct))) {
            String line = reader.readLine();
            while(line != null) {
                String[] data = line.split(",");
                Product Product = new Product(data[0], data[1], data[2], data[3]);
                this.products.add(Product);
                line = reader.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return this.products;
    }
    public void saveInOneShot() {
        String allData = "";
        for (Product Product : this.products) {
            allData += Product.toString() + "\n";
        }
        saveFileLines(allData);
    }
    public void saveProduct(Product Product) {
        getproducts();
        this.products.add(Product);
        saveInOneShot();
    }
    public void saveFileLines(String allData) {
        try {
            FileWriter writer = new FileWriter(this.pathFileProduct);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(allData);
            buffer.newLine();
            buffer.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
