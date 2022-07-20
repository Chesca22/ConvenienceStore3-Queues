package org.francisca.Models;

import org.francisca.Services.Inventory;
import org.francisca.Services.StoreServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreServicesTest {
    //Product product = new Product("bars", "banana", 32, 2.27);
  //  Inventory inventory = new Inventory();
    StoreServices store = new StoreServices();
     @Test
    void checkQuantity() {
        Product product = new Product("bars", "banana", 79, 2.27);
        long ava = store.addToCart("banana", 80);
        assertEquals(40, ava);
       // assertEquals(102,79);
    }

    @Test
    void testCheckQuantity() {
        Product product = new Product("bars", "banana", 34, 2.27);
      //  assertEquals(22,34);
        // assertEquals(102,79);
    }


    @Test
    void sellProduct() {
    }

    @Test
    void updateQuantity() {
    }
}