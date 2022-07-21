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
        private QueueClass queue;
       Store newstore = new Store();
      //  Users user = new Users();

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

            if (newstore.getMyCart().containsKey(customer)) {
                newstore.cart = newstore.getMyCart().get(customer);
                newstore.cart.add(product);
            } else {
                newstore.cart = new ArrayList<Product>();
                newstore.cart.add(product);
                newstore.getMyCart().put(customer, (ArrayList<Product>) newstore.getCart());
            }
            return newstore.getMyCart();
        }


        public boolean sell(Users cashier, Users customer) {
            double totalPrice = 0;
            boolean result = false;
            for (Map.Entry<Users, ArrayList<Product>> entry : newstore.getMyCart().entrySet()) {
                if (entry.getKey().equals(customer)) {
                    for (Product product : newstore.cart) {
                        totalPrice = totalPrice + product.getQuantity() * product.getUnitPrice();

                    }
                    if (cashier.getRoles().equals(Roles.CASHIER)) {
                        if (customer.getWallet() >= totalPrice) {
                            customer.setWallet(customer.getWallet() - totalPrice);
                            queue.addCustomerToQueueList(customer);
                            System.out.println("TOTAL PRICE = " + " $" + totalPrice);
                            result = true;
                        } else {
                            System.out.println(" Insufficient money in wallet");
                            result = false;
                        }
                    }
                }
            }
            return result;
        }


        public void printReceipt(Users customer) {

            for (Map.Entry<Users, ArrayList<Product>> entry : newstore.getMyCart().entrySet()) {
                String si = "SHOPPING CART OF " + " " + entry;
                System.out.println(si);
            }

        }

        public void printAllHashValues(Users customer) {
         double total = 0;

            for (Map.Entry<Users, ArrayList<Product>> entry : newstore.getMyCart().entrySet()) {
                if (entry.getKey().equals(customer)) {
                    ArrayList<Product> rd = newstore.getMyCart().get(customer);
                    for (Product product : rd) {
                        total += product.getUnitPrice();

                    }
                        System.out.println(entry);
                           System.out.println("Total price" + total);
                }
            }

//            public void gettingQuantity(){
//                long total = 0;
//
//                for (Map.Entry<Users, ArrayList<Product>> entry : newstore.getMyCart().entrySet()) {
//                   if (entry.getKey().equals(customer)) {
//                        ArrayList<Product> rd = newstore.getMyCart();
//                        for (Product product : rd) {
//                            product.getQuantity();
//                        }
//                        }
//
//                  //  }
//
//                }

//            public void gettingQuantity(Users customer){
//
//            }
//        }




}