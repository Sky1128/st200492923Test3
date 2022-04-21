/**
 * Name : Pruthvish Patel
 * Student Number : 200492923
 */

package com.example.st200492923test3;

import java.util.ArrayList;

public class Store {
    private int storeID;
    private String streetAddress;
    private String city;
    private String phoneNumber;
    ArrayList<Product> inventory;

    public Store(int storeID, String streetAddress, String city, String phoneNumber) {
        setStoreID(storeID);
        setStreetAddress(streetAddress);
        setCity(city);
        setPhoneNumber(phoneNumber);
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        if(storeID > 1 && storeID < 200)
            this.storeID = storeID;
        else
            throw new IllegalArgumentException("This store number does not exist please enter valid stoer number");
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        if(streetAddress.length() >= 5)
            this.streetAddress = streetAddress;
        else
            throw new IllegalArgumentException("Enter a valid street address");
    }

    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        String[] cities = {"Halifax","Fredricton","Charlottetown","Saint John's","Quebec","Toronto","Winnipeg",
                "Regina","Edmonton","Victoria","Whitehorse","Yellow knife","Iqaluit"};
        for(int i = 0; i < cities.length; i++) {
            if(city == cities[i])
                this.city = city;
            else
                throw new IllegalArgumentException("Branch is not available in entered city");
        }

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        if(phoneNumber.length() >= 10 && phoneNumber.length() <= 14)
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("Enter a valid phone Number");
    }

    public void addProduct(Product product)
    {
        for(Product e : inventory)
        {
            if (e.getSku() == product.getSku())
            {
                System.out.println("Product already exist in the inventory");
            }
            else
                inventory.add(product);
        }
    }

    public double getInventoryMSRP()
    {
        double totalMSRP = 0 ;
        for(Product e : inventory)
        {
            totalMSRP = (totalMSRP + (e.getUnitInStock()*e.getMsrp()));
        }
        return totalMSRP;
    }

    public int getNumOfProductsInventory()
    {
        int totalUniqueProducts = 0;
        totalUniqueProducts = inventory.size();

        return totalUniqueProducts;
    }

    public String toString()
    {
        String storeString = "\"" + getStreetAddress() + "has " + getNumOfProductsInventory() +"unique products of worth" +"$"  +getInventoryMSRP() + "\"";
        return storeString;
    }



}
