package web311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String addForm(Model model) {
        return "add";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("id") long id, Model model) {
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

    @GetMapping("/del")
    public String delUser(@RequestParam("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}
