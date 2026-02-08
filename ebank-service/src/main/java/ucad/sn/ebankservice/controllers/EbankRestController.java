package ucad.sn.ebankservice.controllers;

import org.springframework.web.bind.annotation.*;
import ucad.sn.ebankservice.entities.BankAccount;
import ucad.sn.ebankservice.services.EbankService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EbankRestController {

    private final EbankService ebankService;

    public EbankRestController(EbankService ebankService) {
        this.ebankService = ebankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> findAll() {
        return ebankService.getAllBankAccounts();
    }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return ebankService.save(bankAccount);
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        return ebankService.getBankAccountById(id);
    }
}
