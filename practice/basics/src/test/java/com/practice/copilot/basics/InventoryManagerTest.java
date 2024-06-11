package com.practice.copilot.basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the InventoryManager class.
 */
public class InventoryManagerTest {
    private InventoryManager inventoryManager;

    /**
     * Sets up the test environment before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        inventoryManager = new InventoryManager();
    }

    /**
     * Tests the addProduct() method of InventoryManager.
     */
    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        assertEquals(1, inventoryManager.listProducts().size());
        assertEquals(product, inventoryManager.listProducts().get(0));
    }

    /**
     * Tests the removeProduct() method of InventoryManager.
     */
    @Test
    public void testRemoveProduct() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        try {
            assertTrue(inventoryManager.removeProduct(1));
            assertEquals(0, inventoryManager.listProducts().size());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    /**
     * Tests the updateProductQuantity() method of InventoryManager.
     */
    @Test
    public void testUpdateProductQuantity() {
        Product product = new Product(1, "Laptop", 10);
        inventoryManager.addProduct(product);
        try {
            assertTrue(inventoryManager.updateProductQuantity(1, 20));
            assertEquals(20, inventoryManager.listProducts().get(0).getQuantity());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    /**
     * Tests the listProducts() method of InventoryManager.
     */
    @Test
    public void testListProducts() {
        Product product1 = new Product(1, "Laptop", 10);
        Product product2 = new Product(2, "Mobile", 20);
        Product product3 = new Product(3, "Tablet", 30);
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);
        inventoryManager.addProduct(product3);
        assertEquals(3, inventoryManager.listProducts().size());
        assertEquals(product1, inventoryManager.listProducts().get(0));
        assertEquals(product2, inventoryManager.listProducts().get(1));
        assertEquals(product3, inventoryManager.listProducts().get(2));
    }
}