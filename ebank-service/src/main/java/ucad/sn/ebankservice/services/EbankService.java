package ucad.sn.ebankservice.services;

import org.springframework.stereotype.Service;
import ucad.sn.ebankservice.entities.BankAccount;
import ucad.sn.ebankservice.feign.CustomerRestClient;
import ucad.sn.ebankservice.model.Customer;
import ucad.sn.ebankservice.repository.BankAccountRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount>  getAllBankAccounts() {
            return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
      BankAccount bankAccount=  bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
      bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
      return bankAccount;
    }

    public List<BankAccount> findByCustomerId(Long customerId) {
        return  bankAccountRepository.findByCustomerId(customerId);
    }


    public BankAccount save(BankAccount bankAccount) {
        try{
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            bankAccount.setCustomer(customer);
            return  bankAccountRepository.save(bankAccount);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }


}
