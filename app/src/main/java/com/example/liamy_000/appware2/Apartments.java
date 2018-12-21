package com.example.liamy_000.appware2;



public class Apartments{//an object class to store data on the apartment

    String apartmentName;
    String landlord;
    String apartmentType;
    int number;

    public Apartments(){

    }

    public Apartments(String apartmentName, String landlord, String apartmentType, int number) {
        this.apartmentName = apartmentName;
        this.landlord = landlord;
        this.apartmentType = apartmentType;
        this.number = number;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public String getLandlord() {
        return landlord;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public int getNumber() {
        return number;
    }

}
