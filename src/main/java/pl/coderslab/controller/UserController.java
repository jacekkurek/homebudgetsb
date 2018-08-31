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
import pl.coderslab.entity.User;
import pl.coderslab.service.BudgetService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/user")
@Log
public class UserController {

    private final UserService userService;


    public UserController(UserService userService, BudgetService budgetService) {
        this.userService = userService;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String performNew(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "user/add";
        }

        try {
            userService.save(user);
        } catch (Exception e) {
            return "user/add";
        }

        return "redirect:/user/all";

    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());

        return "user/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        userService.delete(id);

        return "redirect:/user/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOne(id));
        return "user/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "user/edit";
        }

        userService.save(user);
        return "redirect:/user/all";

    }

}