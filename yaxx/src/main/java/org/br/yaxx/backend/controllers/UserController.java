package org.br.yaxx.backend.controllers;

import org.br.yaxx.backend.models.User;
import org.br.yaxx.backend.models.dtos.UserDTO;
import org.br.yaxx.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService USER_SERVICE;

    public UserController(UserService userService){
        this.USER_SERVICE = userService;
    }

    /* ENDPOINTS */

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserDTO dto
    ){

        User user = USER_SERVICE.insertUser(dto);

        return ResponseEntity.ok(user);

    }

}
