package ro.fasttrackit.curs22;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs22.model.Transaction;
import ro.fasttrackit.curs22.repository.TransactionRepository;

import java.util.List;

@SpringBootApplication
public class Curs22CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs22CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new Transaction("Masa", 2.2),
                    new Transaction("Apa", 223),
                    new Transaction("Laptop", 1.22),
                    new Transaction("Mancare", 242)));
        };
    }
}
