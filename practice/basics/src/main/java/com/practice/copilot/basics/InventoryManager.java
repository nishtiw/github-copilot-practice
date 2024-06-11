package com.practice.copilot.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The InventoryManager class represents a manager for an inventory of products.
 * It uses a Map to store the products and provides methods to add, remove, update, and list products.
 */
public class InventoryManager {
    // Map to store products
    private Map<Integer, Product> products = new HashMap<>();

    /**
     * Adds a product to the inventory.
     *
     * @param product the product to be added
     */
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    /**
     * Removes a product from the inventory based on its ID.
     *
     * @param id the ID of the product to be removed
     * @return true if the product was found and removed successfully, false otherwise
     * @throws Exception if the product with the given ID is not found
     */
    public boolean removeProduct(int id) throws Exception {
        Product product = products.get(id);
        if (product != null) {
            products.remove(id);
            return true;
        } else {
            throw new Exception("Product with id " + id + " not found.");
        }
    }

    /**
     * Updates the quantity of a product in the inventory based on its ID.
     *
     * @param id       the ID of the product to be updated
     * @param quantity the new quantity of the product
     * @return true if the product was found and updated successfully, false otherwise
     * @throws Exception if the product with the given ID is not found
     */
    public boolean updateProductQuantity(int id, int quantity) throws Exception {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            product.setQuantity(quantity);
            return true;
        } else {
            throw new Exception("Product with id " + id + " not found.");
        }
    }

    /**
     * Returns a list of all products in the inventory.
     *
     * @return a list of all products
     */
    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * The main method to test the InventoryManager class.
     *
     * @param args the command line arguments
     * @throws Exception if an error occurs during the execution of the main method
     */
    public static void main(String[] args) throws Exception {
        InventoryManager inventoryManager = new InventoryManager();

        // Adding products
        inventoryManager.addProduct(new Product(1, "Laptop", 10));
        inventoryManager.addProduct(new Product(2, "Mobile", 20));
        inventoryManager.addProduct(new Product(3, "Tablet", 30));

        // Listing products
        inventoryManager.listProducts().forEach(System.out::println);

        // Updating a product quantity
        inventoryManager.updateProductQuantity(2, 25);

        System.out.println("............................................");

        // Listing products after update
        inventoryManager.listProducts().forEach(System.out::println);

        // Removing a product
        inventoryManager.removeProduct(3);

        System.out.println("............................................");

        // Listing products after removal
        inventoryManager.listProducts().forEach(System.out::println);
    }
}
