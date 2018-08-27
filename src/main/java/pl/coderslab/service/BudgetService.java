package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.repository.BudgetRepository;
import pl.coderslab.repository.UserRepository;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository;}

}
