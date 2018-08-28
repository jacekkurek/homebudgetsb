package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Budget;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.BudgetRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final BudgetRepository budgetRepository;

    public CategoryController(CategoryRepository categoryRepository, BudgetRepository budgetRepository) {
        this.categoryRepository = categoryRepository;
        this.budgetRepository = budgetRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("budgets", budgetRepository.findAll());
        return "category/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryRepository.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryRepository.delete(id);
        return "redirect:/category/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryRepository.findOne(id));
        return "category/edit";
    }

    @PostMapping("/edit/*")
    public String edit(Model model, @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            return "user/edit";
        }
        categoryRepository.save(category);
        return "redirect:/category/all";
    }

}
