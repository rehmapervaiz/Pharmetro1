package com.example.pharmetroclient;

public class RewardModel {

    private String titie;
    private String expiryDate;
    private String coupenBody;

    public RewardModel(String titie, String expiryDate, String coupenBody) {
        this.titie = titie;
        this.expiryDate = expiryDate;
        this.coupenBody = coupenBody;
    }

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCoupenBody() {
        return coupenBody;
    }

    public void setCoupenBody(String coupenBody) {
        this.coupenBody = coupenBody;
    }
}
