package baykov.daniel.springboottransactiondemo.repositories;

import baykov.daniel.springboottransactiondemo.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
