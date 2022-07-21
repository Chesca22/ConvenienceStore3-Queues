package org.francisca.Services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Models.Product;
import org.francisca.Models.Store;
import org.francisca.Models.Users;

import java.util.*;

@Setter
@Getter
public class QueueClass {
 Store store = new Store();
private Product product;
private StoreServices storeServices;


    // ***************************** IMPLEMENTATION ONE(1) BASED FIRST COME FIRST SERVE **********************//

    public void addCustomerToQueueList(Users customer){
            store.getQueueList().add(customer);

    }

    public void printQueue() {
        while (store.getQueueList().peek() != null) {
            System.out.println(store.getQueueList().poll() + " has successfully purchased item and receipt issued");
        }
    }
// ***************************** IMPLEMENTATION ONE(1) BASED FIRST COME FIRST SERVE **********************//
    public void addCustomerToPriorityQueueList(Users customer){
          store.getPriorityQueueList().add(customer);
        }

    public void printingWithPriorityQueue() {
        while (store.getPriorityQueueList().peek() != null) {
            System.out.println(store.getPriorityQueueList().poll() + " has successfully purchased item and receipt issued");
        }
    }
        public
        Comparator<Map.Entry<Users, Product>> valueComparator = new Comparator<Map.Entry<Users, Product>>() {
            @Override
            public int compare(Map.Entry<Users, Product> o1, Map.Entry<Users, Product> o2) {
                long v1 = o1.getValue().getQuantity();
                long v2 = o2.getValue().getQuantity();
                 v1.compareTo(v2);
                 return 0;
            }
        };
    List<Map.Entry<Users, ArrayList<Product>>> listOfEnteries = new ArrayList<Map.Entry<Users, ArrayList<Product>>(store.getMyCart());
    Collections.sort(listOfEnteries, valueComparator);
    }





