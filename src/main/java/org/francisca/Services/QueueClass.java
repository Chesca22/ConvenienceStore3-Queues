package org.francisca.Services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Models.Product;
import org.francisca.Models.Store;
import org.francisca.Models.Users;
@Setter
@Getter
public class QueueClass {

 Store store = new Store();
private Product product;



    // ***************************** IMPLEMENTATION ONE(1) BASED FIRST COME FIRST SERVE **********************//

    public String addCustomerToQueueList(Users customer){
        if(store.myCart.containsKey(customer)){
            store.priorityQueueList.add(customer);
            return "*" + customer.getName() + ", Your request is processing";
        } else return "No customer";
    }
    //Selling to customers based on First come, first served
    public String sellToCustomerUsingQueue(Product product){
        Users customer = store.priorityQueueList.peek();
           if(store.myCart.containsKey(customer) && store.myCart.containsValue(getProduct())){


           }

            for(int i= 0; i<store.priorityQueueList.size(); i++){

            }


        return " ";
}
}