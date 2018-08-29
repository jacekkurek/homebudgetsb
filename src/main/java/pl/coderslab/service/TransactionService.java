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

    public List<Transaction> reportBetweenDate(LocalDate before, LocalDate after) {
        return transactionRepository.findByBetweenDate(before, after);
    }

    public Transaction save (Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Transaction findOne (Long id){
        return transactionRepository.findOne(id);
    }

    public void delete (Long id){
        transactionRepository.delete(id);
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public Double sumByType(String a) {
        return transactionRepository.sumByType(a);
    }
}
