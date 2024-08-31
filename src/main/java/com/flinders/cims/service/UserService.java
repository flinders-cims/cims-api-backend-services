package com.flinders.cims.service;

import com.flinders.cims.model.User;
import com.flinders.cims.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User registerUser(User user) throws Exception {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Username '" + user.getUsername() + "' is already taken.");
        }

        // Generate a random 4-digit userId
        int userId = generateRandomUserId();
        String userName = generateUserName(userId, user.getLastName());
        // Ensure the userId is unique
        while (userRepository.findById(userId).isPresent()) {
            userId = generateRandomUserId();
        }
        user.setUserId(userId);
        user.setUsername(userName);
        return userRepository.save(user);
    }

    public boolean authenticateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setFirstName(user.getFirstName() != null ? user.getFirstName(): existingUser.getFirstName());
            existingUser.setLastName(user.getFirstName() != null ? user.getLastName(): existingUser.getLastName());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    private int generateRandomUserId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    private String generateUserName(int userId, String lastName) {
        // Ensure the last name has at least 4 characters
        String usernamePart = (lastName != null && lastName.length() >= 4) ? lastName.substring(0, 4).toLowerCase() : "cims";
        // Construct the username
        return usernamePart + userId + "@flinders.edu.au";
    }
}
