package org.br.yaxx.backend.services;

import org.br.yaxx.backend.exceptions.UserException;
import org.br.yaxx.backend.models.User;
import org.br.yaxx.backend.models.dtos.UserDTO;
import org.br.yaxx.backend.repositories.UserRepository;
import org.br.yaxx.backend.utils.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    /* VARS */

    private final UserRepository USER_REPOSITORY;

    public UserService(UserRepository userRepository){
        this.USER_REPOSITORY = userRepository;
    }

    /* CRUD */

    public User insertUser(UserDTO dto){

        Optional<User> user_optional = getUserByMail(dto.mail());

        if(user_optional.isPresent())
            throw new UserException("User already exist");

        User user;

        try{

            user = UserMapper.createUser(dto);

            USER_REPOSITORY.save(user);

        }catch (Exception e){
            throw new UserException("Insert user dont work");
        }

        return user;
    }

    public Optional<User> getUserByMail(String mail){
        return USER_REPOSITORY.getUserByMail(mail);
    }




}
