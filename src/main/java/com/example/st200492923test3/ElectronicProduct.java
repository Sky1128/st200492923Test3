/**
 * Name : Pruthvish Patel
 * Student Number : 200492923
 */

package com.example.st200492923test3;

public class ElectronicProduct extends Product{
    private int voltage;
    private boolean remote;

    public ElectronicProduct(int sku, String name, double msrp, int unitInStock,  Manufacturer manufacturer, int voltage,boolean remote) {
        super(sku, name, msrp, unitInStock, manufacturer);
        setVoltage(voltage);
        setRemote(remote);
    }

    public int getVoltage() {
        return voltage;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public void setVoltage(int voltage) {
        if(voltage == 120 || voltage == 230 || voltage == 240 )
            this.voltage = voltage;
        else
            throw new IllegalArgumentException("Product with entered voltage is not available");
    }

}
