package ro.fasttrackit.curs22.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs22.model.Transaction;
import ro.fasttrackit.curs22.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public Optional<Transaction> getTransaction(Integer id) {
        return repository.findById(id);
    }

    public Optional<Transaction> delete(int id) {
        Optional<Transaction> toDelete = repository.findById(id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Transaction add(Transaction transaction) {
        return repository.save(transaction);
    }
}
