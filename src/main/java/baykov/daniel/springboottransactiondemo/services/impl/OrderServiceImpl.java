package baykov.daniel.springboottransactiondemo.services.impl;

import baykov.daniel.springboottransactiondemo.dto.OrderRequest;
import baykov.daniel.springboottransactiondemo.dto.OrderResponse;
import baykov.daniel.springboottransactiondemo.entities.Order;
import baykov.daniel.springboottransactiondemo.entities.Payment;
import baykov.daniel.springboottransactiondemo.exception.PaymentException;
import baykov.daniel.springboottransactiondemo.repositories.OrderRepository;
import baykov.daniel.springboottransactiondemo.repositories.PaymentRepository;
import baykov.daniel.springboottransactiondemo.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type is not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
