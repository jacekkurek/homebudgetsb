package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Category;
import pl.coderslab.service.BudgetService;
import pl.coderslab.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final BudgetService budgetService;

    public CategoryController(CategoryService categoryService, BudgetService budgetService) {
        this.categoryService = categoryService;
        this.budgetService = budgetService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("budgets", budgetService.findAll());
        return "category/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryService.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findOne(id));
        model.addAttribute("budgets", budgetService.findAll());
        return "category/edit";
    }

    @PostMapping("/edit/*")
    public String edit(Model model, @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            return "user/edit";
        }
        categoryService.save(category);
        return "redirect:/category/all";
    }

}
