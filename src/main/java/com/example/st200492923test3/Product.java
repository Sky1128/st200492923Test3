/**
 *Nane : Pruthvish Patel
 *Student Number : 200492923
 */
package com.example.st200492923test3;

public class Product {
    private int sku;
    private String name;
    private double msrp;
    private int unitInStock;
    private int unitSold;
    private  Manufacturer manufacturer;


    public Product(int sku, String name, double msrp, int unitInStock,  Manufacturer manufacturer) {
        setSku(sku);
        setName(name);
        setMsrp(msrp);
        setUnitInStock(unitInStock);
        setManufacturer(manufacturer);
        setUnitSold(0);
    }

    public int getSku() {
        return sku;
    }


    public void setSku(int sku) {
        if(sku >= 1000 && sku <= 9999)
            this.sku = sku;
        else
            throw new IllegalArgumentException("Please enter a valid sku value");

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        name = name.trim();
        if(name.length() >= 2)
            this.name = name;
        else
            throw new IllegalArgumentException("Please enter a valid Product Name");
    }


    public double getMsrp() {
        return msrp;
    }


    public void setMsrp(double msrp) {
        if(msrp  >= 0 && msrp <= 100)
            this.msrp = msrp;
        else
            throw new IllegalArgumentException("Please enter a valid product price");
    }


    public int getUnitInStock() {
        return unitInStock;
    }


    public void setUnitInStock(int unitInStock) {
        if(unitInStock > 0)
            this.unitInStock = unitInStock;
        else
            throw  new IllegalArgumentException("This item is out of stock , pleae try again later");
    }


    public int getUnitSold() {
        return unitSold;
    }



    public void setUnitSold(int unitSold) {
        this.unitSold = unitSold;
    }


    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    public int sellItem(int orderedUnits)
    {
        int numberOfUnitSold;
        int inStock = getUnitInStock();
        if(inStock >= orderedUnits)
        {
            unitSold = unitSold + orderedUnits;
            setUnitInStock(inStock - orderedUnits);
            numberOfUnitSold = orderedUnits;
        }
        else
        {
            unitSold = unitSold + inStock;
            numberOfUnitSold = inStock;
        }
     return numberOfUnitSold;

    }

    public double getStockValue()
    {
        double stockValue = getUnitInStock() * getMsrp();
        return  stockValue;
    }
    public double getRevenue()
    {
        double totalRevenue = getUnitSold()*getMsrp();
        return totalRevenue;
    }

    public String toString()
    {
        String productString = "\"" + String.valueOf(getSku()) + "-" + getName() +  "\"" ;
        return productString;
    }

}
