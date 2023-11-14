package org.br.yaxx.backend.controllers;

import org.br.yaxx.backend.models.User;
import org.br.yaxx.backend.models.dtos.UserDTO;
import org.br.yaxx.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{mail}")
    public ResponseEntity<?> getUserByMail(
            @PathVariable String mail
    ){

        User user = USER_SERVICE.getUserByMail(mail);

        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<?> editUserByMail(
            @RequestBody UserDTO dto
    ){

        User user = USER_SERVICE.editUserByMail(dto);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{mail}")
    public ResponseEntity<?> deleteUserByMail(
            @PathVariable String mail
    ){

        User user = USER_SERVICE.deleteUser(mail);

        return ResponseEntity.ok(user);
    }

}
