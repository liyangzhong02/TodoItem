package org.marre.webapplication.controller;
import org.marre.webapplication.model.User;
import org.marre.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedInUser = userService.Login(user);
            return ResponseEntity.ok(loggedInUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

    @RequestMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            User registerUser = userService.addUser(user);
            return ResponseEntity.ok(registerUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public String delUser(@RequestBody User user){
        User foundUser = userService.delUser(user);
        if (foundUser != null) {
            return "delete successful!";
        } else {
            return "User not found";
        }
    }

    @RequestMapping("/select")
    public String findUserById(@RequestBody User user){
        User foundUser = userService.findUserById(user.getId());
        if (foundUser != null) {
            return foundUser.toString();
        } else {
            return "User not found";
        }
    }
}
