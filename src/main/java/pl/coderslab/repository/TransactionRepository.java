package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where timeTransaction > :after and timeTransaction < :before")
    List<Transaction> findByBetweenDate(@Param("after") LocalDate after,@Param("before") LocalDate before);

//    @Query("select sum(value) from Transaction t where t.type.name = 'planned_income' and t.user.name = :a " +
//            "and t.timeTransaction < t.timeTransaction + 1 MONTH")
//    Double sumByTypea(@Param("a") String a);

    @Query("select sum(value) from Transaction t where t.type.name = 'planned_income' and t.user.name = :username " +
            " and timeTransaction > :after and timeTransaction < :before")
    Double sumByType(@Param("username") String username, @Param("after") LocalDate after, @Param("before") LocalDate before);

    @Query("select s.salary from User s where s.name = :username")
    double salaryByName(@Param("username") String username);
}
