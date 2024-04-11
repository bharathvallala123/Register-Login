package com.example.RegisterLogin.controller;

import com.example.RegisterLogin.Model.User;
import com.example.RegisterLogin.Service.RegistrationService;
import com.example.RegisterLogin.UserDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Users")
public class RegistrationController {
    @Autowired
    RegistrationService registerService;
    public void RegistrationService(UserDao userDao) {
        this.userDao=userDao;
    }
    @RequestMapping("/")
            public String index(){
        return "index.html";
    }
    UserDao userDao;

    @GetMapping("allUsers") //fetch all the data
    public List<User> getAllUsers(){
        return registerService.getAllUsers();
    }

    @GetMapping("role/{role}")
    public List<User> getUserbyRole(@PathVariable("role") String role){
        return registerService.getUserbyRole(role);

    }

    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        return registerService.addUser(user);
    }


    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return registerService.updateUser(id, user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return registerService.deleteUser(id);
    }


}
