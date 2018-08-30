package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Transaction;
import pl.coderslab.service.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/transaction")
@Log
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;
    private final TypeService typeService;
    private final BudgetService budgetService;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    public TransactionController(TransactionService transactionService, UserService userService,
                                 TypeService typeService, BudgetService budgetService,
                                 CategoryService categoryService, SubcategoryService subcategoryService) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.typeService = typeService;
        this.budgetService = budgetService;
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("budgets", budgetService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "transaction/add";
    }

    @PostMapping("/add")
    public String performNew(Model model, @Valid Transaction transaction, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            model.addAttribute("types", typeService.findAll());
            model.addAttribute("budgets", budgetService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("subcategories", subcategoryService.findAll());
            return "transaction/add";
        }

        transaction.setTimeAdded(LocalDateTime.now());
        transactionService.save(transaction);
        return "redirect:/transaction/all";

    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        return "transaction/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        transactionService.delete(id);
        return "redirect:/transaction/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("transaction", transactionService.findOne(id));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("budgets", budgetService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "transaction/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Transaction transaction, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            model.addAttribute("types", typeService.findAll());
            model.addAttribute("budgets", budgetService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("subcategories", subcategoryService.findAll());
            return "transaction/edit";
        }

        transaction.setTimeAdded(LocalDateTime.now());
        transactionService.save(transaction);
        return "redirect:/transaction/all";

    }

    @GetMapping("/report")
    public String report() {
        return "transaction/report";
    }

    @PostMapping("/report")
    public String report(Model model, @RequestParam String after, @RequestParam String before) {
        LocalDate afterDate = LocalDate.parse(after);
        LocalDate beforeDate = LocalDate.parse(before);
        List<Transaction> reports = transactionService.reportBetweenDate(afterDate, beforeDate);
        model.addAttribute("reports", reports);
        return "transaction/report";
    }

    @GetMapping("/salary")
    public String salary(Model model) {
        model.addAttribute("users", userService.findAll());
        return "transaction/salary";
    }


    @PostMapping("/salary")
    public String salary(Model model, @RequestParam String username, @RequestParam String before, @RequestParam String after) {
        model.addAttribute("users", userService.findAll());
        LocalDate afterDate = LocalDate.parse(after);
        LocalDate beforeDate = LocalDate.parse(before);

        Double st = transactionService.sumByType(username, afterDate, beforeDate);
        double salary = transactionService.salaryByName(username);

        int b = 0;

        if (st >= salary) {
            b = 1;
        } else {
            b = 2;
        }

        model.addAttribute("b", b);

        return "transaction/salary";
    }

}
