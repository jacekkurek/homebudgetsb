package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Subcategory;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.SubcategoryService;


import javax.validation.Valid;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;
    private final CategoryService categoryService;

    public SubcategoryController(SubcategoryService subcategoryService, CategoryService categoryService) {
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subcategory", new Subcategory());
        model.addAttribute("categories", categoryService.findAll());
        return "subcategory/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Subcategory subcategory, BindingResult result) {
        if (result.hasErrors()) {
            return "subcategory/add";
        }
        subcategoryService.save(subcategory);
        return "redirect:/subcategory/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "subcategory/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        subcategoryService.delete(id);
        return "redirect:/subcategory/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("subcategory", subcategoryService.findOne(id));
        return "subcategory/edit";
    }

    @PostMapping("/edit/*")
    public String edit(Model model, @ModelAttribute Subcategory subcategory, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            return "user/edit";
        }
        subcategoryService.save(subcategory);
        return "redirect:/subcategory/all";
    }

}
