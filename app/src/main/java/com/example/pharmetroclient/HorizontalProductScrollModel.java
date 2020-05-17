package com.example.pharmetroclient;

public class HorizontalProductScrollModel {
    private String productID;
    private String produceImage;
    private String ProductTitle;
    private String ProductDescription;
    private String ProductPrice;

    public HorizontalProductScrollModel(String productID,String produceImage, String productTitle, String productDescription, String productPrice) {
        this.produceImage = produceImage;
        this.productID=productID;
        this.ProductTitle = productTitle;
        this.ProductDescription = productDescription;
        this.ProductPrice = productPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProduceImage() {
        return produceImage;
    }

    public void setProduceImage(String produceImage) {
        this.produceImage = produceImage;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
