package org.francisca;

import org.francisca.Models.*;
import org.francisca.Services.Inventory;
import org.francisca.Services.ManagerRole;
import org.francisca.Services.QueueClass;
import org.francisca.Services.StoreServices;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;


public class Main {
        public static void main(String[] args) {

            Users applicant = new Users("Moses", Roles.APPLICANT);
            Users manager = new Users("MD", Roles.MANAGER);
            ManagerRole hireApplicant = new ManagerRole();
           // Users cashier = hireApplicant.canHire(20, "OND", applicant, manager);
           // System.out.println(cashier);
            Product product = new Product();
            System.out.println(">".repeat(100));
            /*All products available in the store*/

            Inventory myInventory = new Inventory();
            myInventory.readingProducts();

            StoreServices newStore = new StoreServices();
            System.out.println("CUSTOMERS IN STORE READY FOR PURCHASE");

            System.out.println(">".repeat(100));

            Users customer1 = new Users("Donald Trump", 001, Roles.CUSTOMER);
            newStore.addToCart(customer1,"banana", 29L);
            newStore.addToCart( customer1,"bran", 10L);

            //System.out.println("*".repeat(100));
            Users customer2 = new Users( " Aliko Dangote", 002, Roles.CUSTOMER);
            newStore.addToCart(customer2, "potato chips", 15L);
            newStore.addToCart(customer2, "pretzels", 2L);

           // System.out.println("*".repeat(100));
            Users customer3 = new Users( "Ngozi Okonjo", 003, Roles.CUSTOMER);
            newStore.addToCart(customer3,"oatmeal raisin", 10L);
            newStore.addToCart(customer3, "whole wheat", 12L);

            //System.out.println("*".repeat(100));
            Users customer4 = new Users( "George Bush", 004, Roles.CUSTOMER);
            newStore.addToCart(customer4,"banana", 10L);
            newStore.addToCart(customer4, "arrowroot", 12L);
            newStore.addToCart(customer4, "whole wheat", 20L);

            System.out.println("*".repeat(100));

            newStore.printAllHashValues(customer1);

            System.out.println(">".repeat(100));
            System.out.println(">".repeat(100));
           // myInventory.printProds();
            Store store = new Store();
            QueueClass queue = new QueueClass();

           //************* IMPLEMENTATION OF FIRST IN FIRST SERVED **************//
            queue.addCustomerToQueueList(customer1);
            queue.addCustomerToQueueList(customer2);
            queue.addCustomerToQueueList(customer3);
            queue.addCustomerToQueueList(customer4);
            queue.printQueue();
            System.out.println("*".repeat(100));
            //************* IMPLEMENTATION OF PIORITY QUEUE **************//
            queue.addCustomerToPriorityQueueList(customer2);
            queue.addCustomerToPriorityQueueList(customer1);
            queue.addCustomerToPriorityQueueList(customer3);
            queue.addCustomerToPriorityQueueList(customer4);
            queue.printingWithPriorityQueue();
        }

}