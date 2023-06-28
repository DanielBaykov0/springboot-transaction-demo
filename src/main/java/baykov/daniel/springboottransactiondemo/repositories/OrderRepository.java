package baykov.daniel.springboottransactiondemo.repositories;

import baykov.daniel.springboottransactiondemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
