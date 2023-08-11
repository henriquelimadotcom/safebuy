package com.trinity.safebuy.core;

import com.trinity.safebuy.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginSubmit {

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password) {

        _user.setUsername(username);
        _user.setPassword(password);

        if (!Objects.equals(_user.getUsername(), "dev")
                | !Objects.equals(_user.getPassword(), "dev")) {
            return "ERROR";
        }
        return "redirect:/home";
    }

    private User _user;
}