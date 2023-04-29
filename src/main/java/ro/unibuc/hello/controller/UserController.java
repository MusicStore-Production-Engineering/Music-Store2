package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.UserEntity;
import ro.unibuc.hello.dto.User;
import ro.unibuc.hello.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserEntity> createUser(@RequestBody User user) {
        UserEntity newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

}
