//package com.wanderplan.wanderplan.controller;
//
//import com.wanderplan.wanderplan.model.User;
//import com.wanderplan.wanderplan.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api/users")
//@CrossOrigin
//public class UserController {
//
//    @Autowired
//    private UserService UserService;
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return UserService.saveUser(user);
//    }
//
//    @GetMapping("/{id}")
//    public Optional<User> getUser(@PathVariable Long id) {
//        return UserService.getUserById(id);
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return UserService.getAllUsers();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        UserService.deleteUser(id);
//    }
//}

package com.wanderplan.wanderplan.controller;

import com.wanderplan.wanderplan.model.User;
import com.wanderplan.wanderplan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserByIdOrNull(id);
        model.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
