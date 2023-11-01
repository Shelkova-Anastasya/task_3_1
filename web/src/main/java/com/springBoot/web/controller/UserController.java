package com.springBoot.web.controller;

import com.springBoot.web.model.User;
import com.springBoot.web.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private ServiceUser serviceUser;
    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        List<User> users =serviceUser.getUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping(value = "/add")
    public String addUserForm(User user) {
        return "add";
    }
    @PostMapping(value = "/add")
    public String addUser(User user) {
        serviceUser.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        serviceUser.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping(value = "/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
       User user= serviceUser.getUser(id);
       model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        user.setName( user.getName());
        user.setAge( user.getAge());
        serviceUser.updateUser(user);
        return "redirect:/";}
}

