package com.example.st200492923test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    private Product product1;
    private Product product2;
    private Store store;

    @BeforeEach
    void setUp() {
        Manufacturer manufacturer = new Manufacturer("Frank's Parts","55 Happy St","705-555-1234");
        product1 = new Product(1001,"widget", manufacturer, 10.99,100);
        product2 = new Product(1002,"spinner", manufacturer, 0.99,500);
        store = new Store(123,"123 Java Circle","Toronto","416-555-1234");
        store.addProduct(product1);
        store.addProduct(product2);
    }

    @Test
    void setStoreID() {
        store.setStoreID(1);
        assertEquals(1,store.getStoreID());
        store.setStoreID(200);
        assertEquals(200, store.getStoreID());
    }

    @Test
    void setStoreIDInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setStoreID(0);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setStoreID(201);});
    }

    //5 or more characters
    @Test
    void setStreetAddress() {
        store.setStreetAddress("5 Happy St");
        assertEquals("5 Happy St",store.getStreetAddress());
        store.setStreetAddress("5 Hap");
        assertEquals("5 Hap",store.getStreetAddress());
    }

    @Test
    void setStreetAddressInvalid()
    {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setStreetAddress("1234");});
    }


    //
    @Test
    void setCity() {
        List<String> cities = Arrays.asList("Halifax","Fredricton","Charlottetown","Saint John's","Quebec","Toronto","Winnipeg","Regina","Edmonton","Victoria","Whitehorse","Yellowknife","Iqaluit");
        for (String city : cities)
        {
            store.setCity(city);
            assertEquals(city, store.getCity());
        }
    }

    @Test
    void setCityLowerCase() {
        List<String> citiesUC = Arrays.asList("Halifax","Fredricton","Charlottetown","Saint John's","Quebec","Toronto","Winnipeg","Regina","Edmonton","Victoria","Whitehorse","Yellowknife","Iqaluit");
        List<String> citiesLC = Arrays.asList("halifax","fredricton","charlottetown","saint John's","quebec","toronto","winnipeg","regina","edmonton","victoria","whitehorse","yellowknife","iqaluit");
        for (int i=0; i<citiesLC.size(); i++)
        {
            store.setCity(citiesLC.get(i));
            assertEquals(citiesUC.get(i), store.getCity());
        }

        //test that the first character is set to upper case and the leading/trailing white spaces are removed
        store.setCity(" toronto ");
        assertEquals("Toronto", store.getCity());
    }

    @Test
    void setCityInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setCity("Orillia");});
    }

    @Test
    void setPhoneNumber() {
        store.setPhoneNumber("(705)555-1234");
        assertEquals("(705)555-1234", store.getPhoneNumber());
        store.setPhoneNumber("7055551234");
        assertEquals("7055551234", store.getPhoneNumber());
        store.setPhoneNumber("(705) 555-1234");
        assertEquals("(705) 555-1234", store.getPhoneNumber());
    }
    @Test
    void setPhoneNumberInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setPhoneNumber("705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setPhoneNumber(" 705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setPhoneNumber("705555123 ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.setPhoneNumber("(705) 555-12345");});
    }

    @Test
    void addProduct() {
        Manufacturer manufacturer = new Manufacturer("Intel","12 Sweet St","705-555-9876");
        Product newProduct = new Product(1003,"calculator",manufacturer,99.99,50);
        store.addProduct(newProduct);
        assertEquals(3, store.getNumOfProductsInventory());
    }

    //product1 is already listed in the store, so it should be rejected
    @Test
    void addProductInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{store.addProduct(product1);});
    }


    //    product1 = new Product(1001,"widget", manufacturer, 10.99,100); 10.99 * 100 = 1099.00
//    product2 = new Product(1002,"spinner", manufacturer, 0.99,500); 0.99 * 500 = 495.00
    // 1099 + 495 = 1594
    @Test
    void getInventoryMSRP() {
        assertEquals(1594, store.getInventoryMSRP());
    }


    @Test
    void testToString() {
        assertEquals("123 Java Circle has 2 unique products worth $1594.00", store.toString());
    }
}