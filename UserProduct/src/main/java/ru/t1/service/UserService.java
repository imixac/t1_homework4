package ru.t1.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.t1.dto.UserDTO;
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

//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        return new UserDTO(user.getId(), user.getUsername());
//        return userRepository.findById(id).orElse(null);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));
        return new UserDTO(user.getId(), user.getUsername());
    }

    public User getByIdWithProducts(Long id) {
        return userRepository.findByIdWithProducts(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
