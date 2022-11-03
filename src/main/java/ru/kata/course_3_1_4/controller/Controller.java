package ru.kata.course_3_1_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.course_3_1_4.entity.User;
import ru.kata.course_3_1_4.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private final UserService userService;


    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/principal_user")
    public User getPrincipalUser(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "user with id: " + id + " was deleted";
    }
}
