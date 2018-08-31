package pl.coderslab.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.User;
import pl.coderslab.service.BudgetService;
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final BudgetService budgetService;
    private final UserService userService;

    public ApiController(BudgetService budgetService, UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }

    @RequestMapping("/budgets/{selectedUserId}")
    public List<Budget> getBudgets(@PathVariable Long selectedUserId){
        return userService.findOne(selectedUserId).getBudgets();
    }

}
