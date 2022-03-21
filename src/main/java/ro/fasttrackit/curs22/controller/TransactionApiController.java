package ro.fasttrackit.curs22.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs22.model.Transaction;
import ro.fasttrackit.curs22.service.TransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionApiController {
    private final TransactionService service;

    public TransactionApiController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.add(transaction);
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable int id) {
        return service.delete(id)
                .orElse(null);
    }
}
