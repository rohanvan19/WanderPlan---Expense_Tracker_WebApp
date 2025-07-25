package com.wanderplan.wanderplan.service;

import java.util.List;
import java.util.Optional;

import com.wanderplan.wanderplan.model.User;
import com.wanderplan.wanderplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsersOrderedById() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "userId"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());

            // Only update the password if a new one is provided
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
                user.setPassword(updatedUser.getPassword());
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    public User getUserByIdOrNull(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public long countUsers() {
        return userRepository.count();
    }
}
