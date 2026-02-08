package ucad.sn.ebankservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ucad.sn.ebankservice.entities.BankAccount;
import ucad.sn.ebankservice.repository.BankAccountRepository;
import ucad.sn.ebankservice.services.EbankService;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EbankService ebankService) {
        return args -> {
               for (int i = 0; i <=3 ; i++) {
                   for (int j = 0; j < 5; j++) {
                      ebankService.save(BankAccount.builder()
                                      .type(Math.random()> 0.5 ? "CURRENT-ACCOUNt" : "SAVING-ACCOUNT" )
                                      .balance(1000 + Math.random()*60000)
                                      .customerId(i)
                              .build()) ;
                   }
               }
        } ;
    }
}
