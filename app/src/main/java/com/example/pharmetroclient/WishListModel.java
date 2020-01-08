package com.example.pharmetroclient;

public class WishListModel {
    private int productImage;
    private int totalRatings;
    private int freeCoupens;
    private String rating;
    private String productPrice;
    private String cuttedPrice;
    private String paymentMethod;
    private String productTitle;

    public WishListModel(int productImage, int totalRatings, int freeCoupens, String rating, String productPrice, String cuttedPrice, String paymentMethod, String productTitle) {
        this.productImage = productImage;
        this.totalRatings = totalRatings;
        this.freeCoupens = freeCoupens;
        this.rating = rating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentMethod = paymentMethod;
        this.productTitle = productTitle;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public int getFreeCoupens() {
        return freeCoupens;
    }

    public void setFreeCoupens(int freeCoupens) {
        this.freeCoupens = freeCoupens;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
