package ucad.sn.ebankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucad.sn.ebankservice.entities.BankAccount;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
             List<BankAccount> findByCustomerId(Long customerId);
}
