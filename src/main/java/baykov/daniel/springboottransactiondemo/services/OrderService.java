package baykov.daniel.springboottransactiondemo.services;

import baykov.daniel.springboottransactiondemo.dto.OrderRequest;
import baykov.daniel.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
