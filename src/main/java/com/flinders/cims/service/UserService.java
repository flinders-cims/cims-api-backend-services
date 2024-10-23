package com.flinders.cims.service;

import com.flinders.cims.model.User;
import com.flinders.cims.model.UserDTO;
import com.flinders.cims.repository.UserRepository;
import com.flinders.cims.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RandomNumber randomNumber;


    public User registerUser(UserDTO userDTO) throws Exception {

        if (userRepository.findByEmailId(userDTO.getEmailId()).isPresent()) {
            throw new Exception("Email id '" + userDTO.getEmailId() + "' already exist in the System.");
        }

        // Generate a random 4-digit userId
        int userId = randomNumber.generateRandomNumber();
        String userName = generateUserName(userId, userDTO.getLastName());
        // Ensure the userId is unique
        while (userRepository.findById(userId).isPresent()) {
            userId = randomNumber.generateRandomNumber();
        }
        User user = new User();
        user.setUserId(userId);
        user.setUsername(userName);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setEmailId(userDTO.getEmailId());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setManagerUserName(userDTO.getManagerUserName());
        user.setHigherApproverUsername(userDTO.getHigherApproverUsername());
        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);  // Return null if authentication fails
    }

    public boolean authenticateUsers(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, UserDTO userDTO) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setPhoneNumber(userDTO.getPhoneNumber() !=0 ? userDTO.getPhoneNumber(): existingUser.getPhoneNumber());
            existingUser.setFirstName(userDTO.getFirstName() != null ? userDTO.getFirstName(): existingUser.getFirstName());
            existingUser.setLastName(userDTO.getLastName() != null ? userDTO.getLastName(): existingUser.getLastName());
            existingUser.setManagerUserName(userDTO.getManagerUserName() != null ? userDTO.getManagerUserName(): existingUser.getManagerUserName());
            existingUser.setPassword(userDTO.getPassword() != null ? userDTO.getPassword(): existingUser.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public String deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return "user deleted";
        }
        return "";
    }

    private String generateUserName(int userId, String lastName) {
        // Ensure the last name has at least 4 characters
        String usernamePart = (lastName != null && lastName.length() >= 4) ? lastName.substring(0, 4).toLowerCase() : "cims";
        // Construct the username
        return usernamePart + userId + "@flinders.edu.au";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
