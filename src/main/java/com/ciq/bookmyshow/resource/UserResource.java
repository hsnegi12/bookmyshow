package com.ciq.bookmyshow.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.bookmyshow.model.User;
import com.ciq.bookmyshow.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/add")
    public void addUserToDB(@RequestBody final User user) {
        userRepository.save(user);
    }

}
