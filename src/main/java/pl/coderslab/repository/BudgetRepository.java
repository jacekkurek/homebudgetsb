package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.User;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface BudgetRepository extends JpaRepository<Budget, Long> {

//    @Query ("select b.users from b Budget where b.id = :id")
//    List<User> getBudgetUsersList (@Param("id") long id);

}
