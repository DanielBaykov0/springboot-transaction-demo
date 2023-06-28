package baykov.daniel.springboottransactiondemo.dto;

import baykov.daniel.springboottransactiondemo.entities.Order;
import baykov.daniel.springboottransactiondemo.entities.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
