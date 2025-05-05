package ru.t1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.t1.entity.User;
import ru.t1.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
//findAll
        userRepository.findAll().forEach(user -> log.info("User: {}", user.toString()));
//findById
        log.info("User: {}", userRepository.findById(1L));
//findByName
        log.info("User: {}", userRepository.findByUsername("Misha"));
//deleteById
        userRepository.deleteById(1L);
//addNewUser
        addUser("Misha10");

        userRepository.findAll().forEach(user -> log.info("User: {}", user.toString()));
    }

    private void addUser(String username) {
        User newUser =User.builder().username(username).build();
        userRepository.save(newUser);

    }
}
