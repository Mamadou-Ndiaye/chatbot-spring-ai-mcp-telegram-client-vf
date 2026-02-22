package ucad.sn.ebankservice.services;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
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

    @McpTool(description = "Get all bank accounts")
    public List<BankAccount>  getAllBankAccounts() {
            return bankAccountRepository.findAll();
    }
    @McpTool(description = "Get a bank account by id")
    public BankAccount getBankAccountById( @McpToolParam(description = "The id of the bank Account") String id) {
      BankAccount bankAccount=  bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
      bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
      return bankAccount;
    }

    public List<BankAccount> findByCustomerId(Long customerId) {
        return  bankAccountRepository.findByCustomerId(customerId);
    }


    @McpTool(description = "Save a new bank account")
    public BankAccount save( @McpToolParam(description = "Save new bak account (balance,type,customerId)") BankAccount bankAccount) {
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
