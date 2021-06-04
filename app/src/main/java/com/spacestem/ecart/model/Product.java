package com.spacestem.ecart.model;

public class Product {

    private int productImage;
    private String productName;
    private String productMRP;
    private String productPrice;
    boolean isAdded;

    public Product(int productImage, String productName, String productMRP, String productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productMRP = productMRP;
        this.productPrice = productPrice;
        this.isAdded = false;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMRP() {
        return productMRP;
    }

    public void setProductMRP(String productMRP) {
        this.productMRP = productMRP;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }
}
