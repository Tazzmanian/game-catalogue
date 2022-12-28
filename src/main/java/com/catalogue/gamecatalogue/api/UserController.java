package com.catalogue.gamecatalogue.api;

import com.catalogue.gamecatalogue.entity.User;
import com.catalogue.gamecatalogue.model.CreateUserDTO;
import com.catalogue.gamecatalogue.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createUser(@Valid @RequestBody CreateUserDTO user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
