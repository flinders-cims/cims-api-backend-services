package com.flinders.cims.controller;

import com.flinders.cims.model.User;
import com.flinders.cims.model.UserDTO;
import com.flinders.cims.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cims")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Register a new user", description = "Register a new user in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registration Successful"),
            @ApiResponse(responseCode = "409", description = "Conflict - Username already exists")
    })
    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO user) {
        try {
            userService.registerUser(user);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok("Registration Successful");
    }

    @Operation(summary = "User login", description = "Authenticate a user with a username and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    @PostMapping("/user/login")
    public ResponseEntity<User> loginUser(
            @RequestParam String username,
            @RequestParam String password) {
        User validatedUser = userService.authenticateUser(username, password);
        if (validatedUser != null) {
            return ResponseEntity.ok(validatedUser);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/user/logins")
    public ResponseEntity<String> loginUsers(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUsers(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
                return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @Operation(summary = "Get user by ID", description = "Fetch user details by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/user/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Update user details", description = "Update user details by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/user/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(id, userDTO);
        return updatedUser != null ? ResponseEntity.ok("Updated successfully") : ResponseEntity.status(404).body("Update Failed");
    }

    @Operation(summary = "Delete user", description = "Delete a user by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (Objects.equals(userService.deleteUser(id), "user deleted")){
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return new ResponseEntity<>("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of all users in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No users found")
    })
    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}