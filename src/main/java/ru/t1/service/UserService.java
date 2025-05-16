package ru.t1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.t1.entity.User;
import ru.t1.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(String username) {
        User newUser =User.builder().username(username).build();
        userRepository.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User getByIdWithProducts(Long id) {
        return userRepository.findByIdWithProducts(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
