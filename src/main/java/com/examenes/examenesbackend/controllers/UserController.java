package com.examenes.examenesbackend.controllers;

import com.examenes.examenesbackend.entities.Role;
import com.examenes.examenesbackend.entities.User;
import com.examenes.examenesbackend.entities.UserRole;
import com.examenes.examenesbackend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception{

         Set<UserRole> roles= new HashSet<>();
         Role role = new Role();
         role.setIdRole(2L);
         role.setName("NORMAL");

         UserRole userRole= new UserRole();
         userRole.setUser(user);
         userRole.setRole(role);

         return iUserService.saveUser(user, roles);


    }

    @GetMapping("/{username}")
    public User findUsuario(@PathVariable ("username") String username){
        return iUserService.findUser(username);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable ("userid") Long userid){
       iUserService.deleteUser(userid);
    }




}
