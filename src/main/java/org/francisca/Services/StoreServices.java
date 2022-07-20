package org.francisca.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Models.Product;
import org.francisca.Models.Store;
import org.francisca.Models.Users;
import org.francisca.Roles;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


    public class StoreServices {
        private Store store;
        Store newstore = new Store();
        Users user = new Users();

        public boolean addToCart(Users customer, String ItemName, long quantity) {
            if (customer.getRoles().equals(Roles.CUSTOMER)) {
                for (Product prod : Inventory.allProduct) {
                    if (prod.getItemName().equals(ItemName)) {
                        if (prod.getQuantity() >= quantity) {
                            Product newProduct = new Product(ItemName, quantity, prod.getUnitPrice());
                            newProduct.setUnitPrice(prod.getUnitPrice() * quantity);
                            allCustomerCart(customer, newProduct);
                            prod.setQuantity(prod.getQuantity() - quantity);
                            return true;
                        } else if (prod.getQuantity() <= 0) {
                            System.out.println("No item available for purchase");

                        } else {
                            System.out.println("Only " + prod.getQuantity() + " " + prod.getItemName() + "s remaining in store");
                        }
                    }
                }

            }
            return false;
        }

        public Map<Users, ArrayList<Product>> allCustomerCart(Users customer, Product product) {

            if (newstore.myCart.containsKey(customer)) {
                newstore.cart = newstore.myCart.get(customer);
                newstore.cart.add(product);
            } else {
                newstore.cart = new ArrayList<Product>();
                newstore.cart.add(product);
                newstore.myCart.put(customer, newstore.cart);
            }
            return newstore.myCart;
        }


        public boolean sell(Users cashier, Users customer) {
            double totalPrice = 0;
            boolean result = false;
            for (Product product : newstore.cart) {
                totalPrice += product.getUnitPrice() * product.getQuantity();

                if (cashier.getRoles().equals(Roles.CASHIER)) {
                    if (customer.getWallet() >= totalPrice) {
                        customer.setWallet(customer.getWallet() - totalPrice);
                        printReceipt(customer);
                        System.out.println("TOTAL PRICE = " + " $" + totalPrice);
                        result = true;
                    } else {
                        System.out.println(" Insufficient money in wallet");
                        result = false;
                    }
                }
            }

            return result;
        }


        public void printReceipt(Users customer) {
            for (Map.Entry<Users, ArrayList<Product>> entry : newstore.myCart.entrySet()) {
                String si = "SHOPPING CART OF " + " " + entry;
                System.out.println(si);
            }

        }

        public void printAllHashValues() {
            for (Map.Entry<Users, ArrayList<Product>> entry : newstore.myCart.entrySet()) {
                System.out.println(entry);
            }


        }




}