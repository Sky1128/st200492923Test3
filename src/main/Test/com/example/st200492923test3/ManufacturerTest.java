package com.example.st200492923test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManufacturerTest {

    private Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer("Jaret's Parts Depo","555 Happyvale Dr","705-555-1234");
    }

    @Test
    void setName() {
        manufacturer.setName("Quality");
        assertEquals("Quality",manufacturer.getName());
        manufacturer.setName("  Quality  ");
        assertEquals("Quality",manufacturer.getName());
        manufacturer.setName("  quality  ");
        assertEquals("Quality",manufacturer.getName());
        manufacturer.setName("  qu  ");
        assertEquals("Qu",manufacturer.getName());
    }

    @Test
    void setNameInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setName("a");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setName(" a ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setName(" B ");});
    }

    @Test
    void setAddress() {
        manufacturer.setAddress("5 Happy");
        assertEquals("5 Happy", manufacturer.getAddress());
        manufacturer.setAddress(" 12345 ");
        assertEquals("12345", manufacturer.getAddress());
    }

    @Test
    void setAddressInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setAddress("a");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setAddress(" abc ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setAddress(" abcd ");});
    }

    @Test
    void setPhoneNumber() {
        manufacturer.setPhoneNumber("(705)555-1234");
        assertEquals("(705)555-1234", manufacturer.getPhoneNumber());
        manufacturer.setPhoneNumber("7055551234");
        assertEquals("7055551234", manufacturer.getPhoneNumber());
        manufacturer.setPhoneNumber("(705) 555-1234");
        assertEquals("(705) 555-1234", manufacturer.getPhoneNumber());
    }
    @Test
    void setPhoneNumberInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setPhoneNumber("705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setPhoneNumber(" 705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setPhoneNumber("705555123 ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{manufacturer.setPhoneNumber("(705) 555-12345");});
    }


    @Test
    void testToString() {
        assertEquals("Jaret's Parts Depo, 555 Happyvale Dr",manufacturer.toString());
    }

    @Test
    void constructorTests(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("a","555 Happyvale Dr","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer(" a ","555 Happyvale Dr","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer(" B ","555 Happyvale Dr","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great","a","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great"," abc ","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great"," abcd ","705-555-1234");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great","5 Somewhere","705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great","5 Somewhere"," 705555123");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great","5 Somewhere","705555123 ");});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Manufacturer("Great","5 Somewhere","(705) 555-12345");});
    }
}