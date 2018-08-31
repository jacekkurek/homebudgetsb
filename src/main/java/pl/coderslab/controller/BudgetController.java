package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.BudgetService;
import pl.coderslab.service.UserService;


import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/budget")
@Log
public class BudgetController {

    private final BudgetService budgetService;
    private final UserService userService;

    public BudgetController(BudgetService budgetService, UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("budget", new Budget());
        model.addAttribute("users", userService.findAll());
        return "budget/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Budget budget, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "budget/add";
        }

        try {
            budgetService.save(budget);
        } catch (Exception e) {
            return "budget/add";
        }

        return "redirect:/budget/all";

    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("budgets", budgetService.findAll());
        return "budget/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        User u = userService.findOne(id);
        if (u.getBudgets().size() == 1) {
            budgetService.delete(id);
        }
        return "redirect:/budget/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("budget", budgetService.findOne(id));
        model.addAttribute("users", userService.findAll());
        return "budget/edit";
    }

    @PostMapping("/edit/*")
    public String edit(Model model, @Valid Budget budget, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "budget/edit";
        }

        budgetService.save(budget);
        return "redirect:/budget/all";

    }

}
