package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Budget;
import pl.coderslab.repository.BudgetRepository;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) { this.budgetRepository = budgetRepository;}

    public Budget save (Budget budget){ return budgetRepository.save(budget);
    }

    public Budget findOne (Long id){ return budgetRepository.findOne(id);
    }

    public void delete(Long id){
        budgetRepository.delete(id);
    }

    public List<Budget> findAll(){
        return budgetRepository.findAll();
    }



}
