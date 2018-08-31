package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;
import pl.coderslab.service.UserServiceSecurity;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginControll {

    private final UserService userService;
    private final UserServiceSecurity userServiceSecurity;

    public LoginControll(UserService userService, UserServiceSecurity userServiceSecurity) {
        this.userService = userService;
        this.userServiceSecurity = userServiceSecurity;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginAddUser")
    public String loginAddUser(Model model) {
        model.addAttribute("user", new User());
        return "loginAddUser";
    }

    @PostMapping("/loginAddUser")
    public String loginAddUser(Model model, @Valid User user, BindingResult result, @RequestParam String control) {

        List<User> users = userService.findAll();

        for (User u : users) {
            if (u.getName().equals(user.getName())) {
                model.addAttribute("equalsUser", "Uzytkownik juz istnieje.");
                return "loginAddUser";
            }
        }

        if (result.hasErrors()) {
            return "loginAddUser";
        } else if (!user.getPassword().equals(control)) {
            model.addAttribute("equalsPassword", "Nie poprawne haslo.");
            return "loginAddUser";
        }

        userServiceSecurity.saveUser(user);
        return "redirect:/user/edit";

    }

}
