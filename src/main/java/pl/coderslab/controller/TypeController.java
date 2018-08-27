package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Type;
import pl.coderslab.service.TypeService;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    Validator validator;

    @RequestMapping("")
    public String home() {
        return "type/type";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("type", new Type());
        return "type/create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid Type type, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("type", new Type());
            return "type/create";
        } else {
            typeService.save(type);
            return "redirect:/type/list";
        }

    }

    @GetMapping("/read")
    public String read() {
        return "type/read";
    }

    @PostMapping("/read")
    public String read(Model model, @RequestParam Long id) {

        if (id == null) {
            model.addAttribute("information", "Nie podałeś id!");
        } else {
            Type type = typeService.read(id);
            model.addAttribute("type", type);
        }

        return "type/read";

    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("type", new Type());
        } else {
            model.addAttribute("type", typeService.read(id));
        }
        return "type/update";
    }

    @PostMapping("/update")
    public String update(Model model, @Valid Type type, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("type", type);
            return "type/update";
        } else {
            typeService.save(type);
            return "redirect:/type/list";
        }

    }

    @GetMapping("/delete")
    public String delete() {
        return "type/delete";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id) {

        if (id == null) {
            model.addAttribute("information", "Nie podałeś id!");
            return "type/delete";
        } else {
            typeService.delete(id);
            return "redirect:/type/list";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.delete(id);
        return "redirect:/type/list";
    }


    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("types", typeService.finAll());
        return "type/list";
    }

}
