package com.example.st200492923test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;
    private Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer("Frank's Parts","55 Happy St","705-555-1234");
        product = new Product(1001,"widget", 10.99, 100, manufacturer);
    }

    @Test
    void setSku() {
        product.setSku(1000);
        assertEquals(1000,product.getSku());
        product.setSku(9999);
        assertEquals(9999,product.getSku());
    }

    @Test
    void setSkuInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setSku(100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setSku(999);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setSku(10000);});
    }

    @Test
    void setName() {
        product.setName("Quality");
        assertEquals("Quality",product.getName());
        product.setName("  Qu  ");
        assertEquals("Qu",product.getName());
        product.setName("  quality  ");
        assertEquals("quality",product.getName());
        product.setName("  qu  ");
        assertEquals("qu",product.getName());
    }

    @Test
    void setNameInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setName("a");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setName(" a ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setName(" B ");});
    }


    //valid is 0-100
    @Test
    void setMsrp() {
        product.setMsrp(1.57);
        assertEquals(1.57,product.getMsrp());
        product.setMsrp(0.0);
        assertEquals(0,product.getMsrp());
        product.setMsrp(100.0);
        assertEquals(100.00,product.getMsrp());
    }

    @Test
    void setMsrpInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setMsrp(-0.01);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setMsrp(100.01);});
    }


    @Test
    void setUnitsInStock() {
        product.setUnitInStock(100);
        assertEquals(100, product.getUnitInStock());
    }

    @Test
    void setUnitsInStockInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product.setUnitsInStock(-1);});
    }

    //100 units initially, if we sell 10, 90 should be left
    @Test
    void sellItem() {
        int unitsSold = product.sellItem(10);
        assertEquals(10, unitsSold);
        assertEquals(90, product.getUnitInStock());
        assertEquals(10, product.getUnitsSold());
    }

    //100 units initially, if we try to sell 110, it should only sell 100, with 0 remaining in stock
    @Test
    void sellItemNotEnough() {
        int unitsSold = product.sellItem(110);
        assertEquals(100, unitsSold);
        assertEquals(0, product.getUnitsInStock());
        assertEquals(100, product.getUnitsSold());
    }

    @Test
    void getStockValue() {
        assertEquals(1099, product.getStockValue(), 0.01);
    }

    //sell 2 items at 10.99 = 21.98
    @Test
    void getRevenue() {
        product.sellItem(2);
        assertEquals(21.98, product.getRevenue(),0.01);
    }

    @Test
    void testToString() {
        assertEquals("1001-widget",product.toString());
    }

    @Test
    void testSetManufacturer(){
        Manufacturer newManufacturer = new Manufacturer("Bob's Used Parts","1223 Sideways","7055557777");
        product.setManufacturer(newManufacturer);
        assertEquals(newManufacturer, product.getManufacturer());
    }

    @Test
    void productConstructorTests(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(100,"widget", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(999,"widget", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(10000,"widget", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(1001,"a", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(1001," a ", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(1001," B   ", manufacturer, 10.99,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(1001,"widget", manufacturer, -0.01,100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{product = new Product(1001,"widget", manufacturer, 100.01,100);});
    }
}