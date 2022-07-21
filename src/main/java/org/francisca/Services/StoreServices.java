package org.francisca.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Models.Product;
import org.francisca.Models.Store;
import org.francisca.Models.Users;
import org.francisca.Models.customerDTO;
import org.francisca.Roles;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


    public class StoreServices {
           private QueueClass queue;
        private Users users;
       // Users users = new Users();
        private Product product;
    public boolean sell(Users cashier, Users customer) {
        double totalPrice = 0;
        double walletTotal = 0;
        boolean result = false;
        if (cashier.getRoles().equals(Roles.CASHIER)) {
        for(Map.Entry<String, Product> entry: customer.getCart().entrySet()){
            totalPrice += entry.getValue().getQuantity() * entry.getValue().getUnitPrice();
            walletTotal = customer.getWallet() - totalPrice;
                    if (customer.getWallet() >= totalPrice) {
                        customer.setWallet(customer.getWallet() - totalPrice);
                                        result = true;
                    } else {
                        System.out.println(" Insufficient money in wallet");
                        result = false;
                    }
                }

        }
        System.out.println("TOTAL PRICE = " + " $" + totalPrice  + '\n'+
                            "Wallet Balance = " + walletTotal  + '\n' +
                            "sign: " + cashier.getName() + "  for:  PEOPLE STORE LTD");

        return result;
    }

    public String addProductToCart(List<Product> inventory ,  Users customer , String productName , long quantityToBuy){
        String output = null;
        for (Product productInInventory : inventory){
            if (productInInventory.getItemName().equalsIgnoreCase(productName)){
                if (productInInventory.getQuantity() >= quantityToBuy){
                    if (customer.getCart().containsKey(productName)){
                        Product duplicateProduct = customer.getCart().get(productName);
                        duplicateProduct.setQuantity(duplicateProduct.getQuantity() + quantityToBuy);
                        productInInventory.setQuantity(productInInventory.getQuantity() - duplicateProduct.getQuantity());
                        System.out.println(quantityToBuy + " more " + duplicateProduct.getItemName() + "has been added to cart");
                        output = "updated product";
                    }else{
                        customer.getCart().put(productName , new Product(productInInventory.getCategory() , productName , quantityToBuy , productInInventory.getUnitPrice()));
                        productInInventory.setQuantity(productInInventory.getQuantity() - quantityToBuy);
                        output = "product added";
                        System.out.println( quantityToBuy + " "+productName + " has been added to cart");
                    }
                }else{
                    output = "Out of Stock";
                }
            }else {
                output = "Product Not Found";
            }
        }
        return output;
    }



                public void printReceipt(Users customer) {

            for (Map.Entry<String, Product> entry : users.getCart().entrySet()) {

                String si = "SHOPPING CART OF " + " " + entry;
                System.out.println(si);

            }

        }



}