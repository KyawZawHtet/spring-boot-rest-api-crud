package com.kyaw.springbootrestapicrud.controller;

// Step 5

import com.kyaw.springbootrestapicrud.entity.User;
import com.kyaw.springbootrestapicrud.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //build create User REST API
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        System.out.println("User id : " + createdUser.getId());
        System.out.println("User firstname : " + createdUser.getFirstName());
        System.out.println("User lastname : " + createdUser.getLastName());
        System.out.println("User email : " + createdUser.getEmail());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //build get user by ID REST API
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        System.out.println("User id : " + user.getId());
        System.out.println("User firstname : " + user.getFirstName());
        System.out.println("User lastname : " + user.getLastName());
        System.out.println("User email : " + user.getEmail());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //build get all users REST API
    //http://locahost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("User id : " + user.getId());
            System.out.println("User firstname : " + user.getFirstName());
            System.out.println("User lastname : " + user.getLastName());
            System.out.println("User email : " + user.getEmail());
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //build update user REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user) {
        user.setId(userId);
        System.out.println("User id : " + user.getId());
        User updatedUser = userService.updateUser(user);
        System.out.println("User firstname : " + updatedUser.getFirstName());
        System.out.println("User lastname : " + updatedUser.getLastName());
        System.out.println("User email : " + updatedUser.getEmail());
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //build delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        System.out.println("User id : " + userId);
        return new ResponseEntity<>("User id : " + userId + " is successfully deleted!", HttpStatus.OK);
    }

}





































































