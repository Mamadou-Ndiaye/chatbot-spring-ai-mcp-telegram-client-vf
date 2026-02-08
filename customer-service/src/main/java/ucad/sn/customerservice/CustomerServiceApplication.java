package ucad.sn.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ucad.sn.customerservice.entities.Customer;
import ucad.sn.customerservice.service.CustomerService;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerService customerService) {
        return args -> {
              List<String> nameCustomers = List.of("Mamadou","Babacar", "Yacine");
              nameCustomers.forEach(name -> {
                  customerService.saveCustomer(Customer.builder().name(name).email(name + "@gmail.com").build()) ;
              })   ;
        }  ;
    }

}
