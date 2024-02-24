package com.example.jibc5.controller;

import com.example.jibc5.entity.Student;
import com.example.jibc5.entity.User;
import com.example.jibc5.repository.UserRepository;
import com.example.jibc5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.data.domain.Page;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String showUsers(Model model,
                            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(defaultValue = "5") int pageSize) {
        Page<User> usersPage = userService.getAllUsersPaginated(pageNo, pageSize);
        model.addAttribute("users", usersPage.getContent());
        model.addAttribute("totalPages", usersPage.getTotalPages());
        model.addAttribute("currentPage", usersPage.getNumber() + 1);
        return "users";
    }

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

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
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
            model.addAttribute("name", existingUser.getName()); // Thêm thuộc tính "name" vào model
            return "redirect:/students";

        }
    }
}
