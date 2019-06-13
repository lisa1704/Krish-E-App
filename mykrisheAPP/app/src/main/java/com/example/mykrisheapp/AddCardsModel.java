package com.example.mykrisheapp;


public class AddCardsModel {


    public int prodid;
    public String cardname;
    public String cardimage;
    public String carddiscription;
    public float cardprice;

    public AddCardsModel() {
    }

    public AddCardsModel(int prodid, String cardname, String cardimage, String carddiscription, float cardprice) {
        this.prodid = prodid;
        this.cardname = cardname;
        this.cardimage = cardimage;
        this.carddiscription = carddiscription;
        this.cardprice = cardprice;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardimage() {
        return cardimage;
    }

    public void setCardimage(String cardimage) {
        this.cardimage = cardimage;
    }

    public String getCarddiscription() {
        return carddiscription;
    }

    public void setCarddiscription(String carddiscription) {
        this.carddiscription = carddiscription;
    }

    public float getCardprice() {
        return cardprice;
    }

    public void setCardprice(float cardprice) {
        this.cardprice = cardprice;
    }
}
