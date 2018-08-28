package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Transaction;
import pl.coderslab.entity.Type;
import pl.coderslab.repository.TransactionRepository;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> makeTransactionRaport() {
        return transactionRepository.transactionRaport();
    }


}
