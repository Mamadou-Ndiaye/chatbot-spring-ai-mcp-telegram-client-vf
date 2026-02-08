package ucad.sn.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucad.sn.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
