package web311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web311.entity.User;
import web311.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/user")
    public String getAddPage(Model model) {
        return "add";
    }

    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/del/{id}")
    public String delUser(@PathVariable long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}
