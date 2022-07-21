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
    private Queue<Users> queueList = new LinkedList<>();
    public Queue<Users> priorityQueueList = new PriorityQueue<>();



}
