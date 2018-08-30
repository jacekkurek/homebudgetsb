package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Type;
import pl.coderslab.service.TypeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("type", new Type());
        return "type/add";
    }

    @PostMapping("/add")
    public String addNew(@Valid Type type, BindingResult result) {

        if (result.hasErrors()) {
            return "type/add";
        }

        typeService.save(type);
        return "redirect:/type/all";

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("type", typeService.findOne(id));
        return "type/edit";
    }

    @PostMapping("/edit/*")
    public String edit(@Valid Type type, BindingResult result) {

        if (result.hasErrors()) {
            return "type/edit";
        }

        typeService.save(type);
        return "redirect:/type/all";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.delete(id);
        return "redirect:/type/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("types", typeService.findAll());
        return "type/all";
    }

}
