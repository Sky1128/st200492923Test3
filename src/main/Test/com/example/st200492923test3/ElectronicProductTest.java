package com.example.st200492923test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectronicProductTest {

    ElectronicProduct eProduct;
    Manufacturer dyson;

    @BeforeEach
    void setUp() {
        dyson = new Manufacturer("Dyson","55 Everywhere","905-555-1234");
        eProduct = new ElectronicProduct(1004,"hair dryer", 99.99, 10, dyson, 120, false);
    }

    @Test
    void setVoltage() {
        eProduct.setVoltage(120);
        assertEquals(120, eProduct.getVoltage());
        eProduct.setVoltage(230);
        assertEquals(230, eProduct.getVoltage());
        eProduct.setVoltage(240);
        assertEquals(240, eProduct.getVoltage());
    }

    @Test
    void setVoltageInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{eProduct.setVoltage(100);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{eProduct.setVoltage(110);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{eProduct.setVoltage(1000);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{eProduct.setVoltage(220);});
    }

    @Test
    void setConstructorTests(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new ElectronicProduct(1004,"hair dryer", 99.99, 10, dyson, 110, false);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new ElectronicProduct(1004,"hair dryer", 99.99, 10, dyson, 150, false);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new ElectronicProduct(1004,"hair dryer", 99.99, 10, dyson, 180, false);});
    }
}