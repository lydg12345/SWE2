package com.example.liamy_000.appware2;

public class NewAppartment {

    String apartmentName;
    String landlordName;
    String apartmentType;
    String contractDuration;
    String depositAndFees;
    String amenities;

    public NewAppartment() {
    }

    public NewAppartment(String apartmentName, String landlordName, String apartmentType, String contractDuration, String depositAndFees, String amenities) {
        this.apartmentName = apartmentName;
        this.landlordName = landlordName;
        this.apartmentType = apartmentType;
        this.contractDuration = contractDuration;
        this.depositAndFees = depositAndFees;
        this.amenities = amenities;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public String getDepositAndFees() {
        return depositAndFees;
    }

    public String getAmenities() {
        return amenities;
    }
}
