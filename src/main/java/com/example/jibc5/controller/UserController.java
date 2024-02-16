package com.example.jibc5.controller;

import com.example.jibc5.entity.User;
import com.example.jibc5.repository.UserRepository;
import com.example.jibc5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?emailexist";
        }
        userRepository.save(user);
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(required = false) String emailError, @RequestParam(required = false) String passwordError) {
        model.addAttribute("user", new User());
        model.addAttribute("emailError", emailError);
        model.addAttribute("passwordError", passwordError);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            return "redirect:/login?emailError=Email not found!";
        } else if (!existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/login?passwordError=Incorrect password!";
        } else {
            return "redirect:/students";
        }
    }
}
