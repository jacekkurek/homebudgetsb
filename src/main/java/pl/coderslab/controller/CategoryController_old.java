package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Category;
import pl.coderslab.service.BudgetService;
import pl.coderslab.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/categoryold")
public class CategoryController_old {

    private final CategoryService categoryService;
    private final BudgetService budgetService;

    public CategoryController_old(CategoryService categoryService, BudgetService budgetService) {
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
    public String add(@Valid Category category, BindingResult result) {

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
    public String edit(@Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "user/edit";
        }

        categoryService.save(category);
        return "redirect:/category/all";

    }

}
