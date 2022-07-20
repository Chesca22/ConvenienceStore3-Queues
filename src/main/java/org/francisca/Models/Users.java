package org.francisca.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Roles;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Users implements Comparable<Users>{
    private String name;
    private int id;
    private Roles roles;
    private double wallet;
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

    public Users(String name, double wallet){
        this.name= name;
        this.wallet = wallet;
    }

    public Users(String name, Store store){
        this.name= name;
        this.wallet = wallet;
       this.store = getStore();
    }


    @Override
    public String toString() {
        return "New Customer:" +
                " Customer name: " + name + " " +
                ", ID number: " + id;
    }

    @Override
    public int compareTo(Users customer) {
        return customer.id > this.id ? 1:-1;


    }
}
