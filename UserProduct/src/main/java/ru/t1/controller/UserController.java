package ru.t1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.t1.dto.ResponseMessage;
import ru.t1.dto.UserDTO;
import ru.t1.dto.UserProductsDTO;
import ru.t1.entity.Product;
import ru.t1.entity.User;
import ru.t1.service.UserService;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage addUser(@RequestParam(name = "username") String username) {
        userService.addUser(username);
        return new ResponseMessage("Пользователь добавлен: " + username);
    }

    @GetMapping("/get/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
//        return new UserDTO(user.getId(), user.getUsername());
    }

    @GetMapping("/getproduct/{id}")
    public UserProductsDTO getByIdWithProducts(@PathVariable Long id) {
        User user = userService.getByIdWithProducts(id);
        Set<Product> products = user.getProducts();
        return new UserProductsDTO(user.getId(), user.getUsername(),
                products);
    }

}
