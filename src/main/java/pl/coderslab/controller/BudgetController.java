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
import pl.coderslab.repository.BudgetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/budget")
@Log
public class BudgetController {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetController(BudgetRepository budgetRepository, UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("budget", new Budget());
        model.addAttribute("users", userRepository.findAll());

        return "budget/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Budget budget, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());

            System.out.println("EEEEEEEEE");

            return "budget/add";

        }

        budgetRepository.save(budget);
        return "redirect:/budget/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("budgets", budgetRepository.findAll());
        return "budget/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        budgetRepository.delete(id);
        return "redirect:/budget/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("budget", budgetRepository.findOne(id));
        model.addAttribute("users", userRepository.findAll());

        return "budget/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Budget budget, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());

            System.out.println("EEEEEEEEE");

            return "budget/edit";
        }
        budgetRepository.save(budget);
        return "redirect:/budget/all";
    }
}
