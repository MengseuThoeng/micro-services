package org.ite.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.ite.userservice.domain.User;
import org.ite.userservice.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PreAuthorize("hasAuthority('SCOPE_openid')")
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PreAuthorize("hasAuthority('SCOPE_openid')")
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_openid')")
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
