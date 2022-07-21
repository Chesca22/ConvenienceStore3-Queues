package org.francisca.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class customerDTO implements Comparator<customerDTO> {


private String customerName;
private String productName;
private long productQuantity;








    @Override
    public int compare(customerDTO o1, customerDTO o2) {
        return o1.getProductQuantity() < o2.getProductQuantity()? 1 : -1;
    }
}
