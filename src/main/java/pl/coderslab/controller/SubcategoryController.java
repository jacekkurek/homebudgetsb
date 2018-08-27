package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Subcategory;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.SubcategoryRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubcategoryController(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subcategory", new Subcategory());
        model.addAttribute("categories", categoryRepository.findAll());
        return "subcategory/add";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid Subcategory subcategory, BindingResult result) {
        if (result.hasErrors()) {
            return "subcategory/add";
        }
        subcategoryRepository.save(subcategory);
        return "redirect:/subcategory/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("subcategories", subcategoryRepository.findAll());
        return "subcategory/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        subcategoryRepository.delete(id);
        return "redirect:/subcategory/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("subcategory", subcategoryRepository.findOne(id));
        return "subcategory/edit";
    }

    @PostMapping("/edit/*")
    public String edit(Model model, @ModelAttribute Subcategory subcategory, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            return "user/edit";
        }
        subcategoryRepository.save(subcategory);
        return "redirect:/subcategory/all";
    }

}
