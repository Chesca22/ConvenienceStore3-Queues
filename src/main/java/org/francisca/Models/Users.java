package org.francisca.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Roles;

import java.util.Comparator;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Users {
    private String name;
    private int id;
    private Roles roles;
    private double wallet;

    private HashMap<String , Product> cart;
    private Store store;
   /// private customerCart customerAccount;

    public Users(String name) {
        this.name = name;
    }
    public Users(String name, Roles roles) {
        this.name = name;
        this.roles = roles;
    }
    public Users(String name, int id, Roles roles){
        this.name= name;
        this.id = id;
        this.roles = roles;
    }

    public Users(String name, int id, double wallet, Roles roles){
        this.name= name;
        this.id = id;
        this.wallet = wallet;
        this.roles = roles;
        this.cart = new HashMap<>();
    }

    public Users(String name, Store store){
        this.name= name;
        this.wallet = wallet;
       this.store = getStore();
    }


    @Override
    public String toString() {
        return
                " Customer name: " + name + ",  " +
                "ID number:  " + id + "  :  Amount in customer's wallet: " + wallet;
    }

    }
