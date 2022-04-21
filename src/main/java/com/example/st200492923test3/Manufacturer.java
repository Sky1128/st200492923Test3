package com.example.st200492923test3;


public class Manufacturer {
    private String name;
    private String address;
    private String phoneNumber;


    public Manufacturer(String name, String address, String phoneNumber) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
       name =  name.trim();
       String firtschar = name.substring(0,1);
       String remainingName = name.substring(1,name.length());
        if(name.length() >= 2 ) {
                this.name = firtschar.toUpperCase() + remainingName;
            }

        else
        {
            throw new IllegalArgumentException("Please Enter a valid Manufacturer name");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address.trim();

        if(address.length() >= 5 )
            this.address = address;
        else
            throw new IllegalArgumentException("Please enter a valid Manufacturer Address");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        if(phoneNumber.length() >= 10 && phoneNumber.length() <= 14)
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("Please enter a valid Manufacturer Phone Number");
    }

    public String toString()
    {
        String manufracturerString = "\"" + getName() + "'s" + "," + getAddress() + "\"";
        return manufracturerString;

    }



}
