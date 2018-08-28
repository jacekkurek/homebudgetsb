package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Transaction;
import pl.coderslab.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> raportBetweenDate(LocalDate before, LocalDate after) {
        return transactionRepository.findByBetweenDate(before, after);
    }

}
