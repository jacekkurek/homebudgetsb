package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Transaction;

import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t from Transaction t")
    List<Transaction> transactionRaport();

}
