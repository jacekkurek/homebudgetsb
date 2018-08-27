package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Transaction;
import pl.coderslab.repository.TransactionRepository;
import pl.coderslab.repository.UserRepository;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

}
