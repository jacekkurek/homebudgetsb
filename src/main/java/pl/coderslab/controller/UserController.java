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
import pl.coderslab.repository.BudgetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/user")
@Log
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, BudgetRepository budgetRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String performNew(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");

            return "user/add";
        }

        userRepository.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "user/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        userRepository.delete(id);
        return "redirect:/user/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");

            return "user/edit";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }
}