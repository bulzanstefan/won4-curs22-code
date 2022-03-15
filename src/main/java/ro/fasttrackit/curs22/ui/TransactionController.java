package ro.fasttrackit.curs22.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.curs22.service.TransactionService;

@Controller
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    String getTransactionsPage(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        model.addAttribute("user", new User(1, "Ana", 22));
        model.addAttribute("transactions", service.getAll());
        return "transactions";
    }

    record User(int id, String name, int age) {

    }
}
