package org.francisca.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Store {
    public ArrayList<Product> cart = new ArrayList<>();
    public static Map<Users, ArrayList<Product>> myCart = new HashMap<>();
    public Queue<Users> queueList = new LinkedList<>();
    public PriorityQueue<Users> priorityQueueList = new PriorityQueue<>();
    private Product product;
}
