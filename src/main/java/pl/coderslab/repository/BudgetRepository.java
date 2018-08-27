package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.User;

@Repository
@Transactional
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
