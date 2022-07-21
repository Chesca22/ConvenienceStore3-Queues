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
    public List<Product> cart = new ArrayList<>();
    private Map<Users,ArrayList <Product>> myCart = new HashMap<>();
    private Queue<Users> queueList = new LinkedList<>();
    public Queue<Users> priorityQueueList = new PriorityQueue<>();
    private Map<Users, ArrayList<Product>> readyToPrintQueue = new LinkedHashMap<>();
    private Product product;



}
