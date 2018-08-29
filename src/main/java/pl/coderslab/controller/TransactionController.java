package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Transaction;
import pl.coderslab.repository.*;
import pl.coderslab.service.TransactionService;
import pl.coderslab.service.TypeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/transaction")
@Log
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;
    private final UserRepository userRepository;
    private final TypeService typeService;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService, UserRepository userRepository, TypeService typeService, BudgetRepository budgetRepository, CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
        this.userRepository = userRepository;
        this.typeService = typeService;
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("types", typeService.finAll());
        model.addAttribute("budgets", budgetRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("subcategories", subcategoryRepository.findAll());
        return "transaction/add";
    }

    @PostMapping("/add")
    public String performNew(Model model, @Valid Transaction transaction, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("types", typeService.finAll());
            model.addAttribute("budgets", budgetRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("subcategories", subcategoryRepository.findAll());

            System.out.println("EEEEEEEEE");
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "transaction/add";
        } else {

        }

        transaction.setTimeAdded(LocalDateTime.now());
        transactionRepository.save(transaction);
        return "redirect:/transaction/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transaction/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        transactionRepository.delete(id);
        return "redirect:/transaction/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("transaction", transactionRepository.findOne(id));
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("types", typeService.finAll());
        model.addAttribute("budgets", budgetRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("subcategories", subcategoryRepository.findAll());

        return "transaction/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Transaction transaction, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("types", typeService.finAll());
            model.addAttribute("budgets", budgetRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("subcategories", subcategoryRepository.findAll());

            return "transaction/edit";
        }
        transaction.setTimeAdded(LocalDateTime.now());
        transactionRepository.save(transaction);
        return "redirect:/transaction/all";
    }

    @GetMapping("/raport")
    public String raport() {
        return "transaction/raport";
    }

    @PostMapping("/raport")
    public String raport(Model model, @RequestParam String after, @RequestParam String before) {
        LocalDate afterDate = LocalDate.parse(after);
        LocalDate beforeDate = LocalDate.parse(before);
        List<Transaction> raports = transactionService.raportBetweenDate(afterDate, beforeDate);
        model.addAttribute("raports", raports);
        return "transaction/raport";
    }

}
