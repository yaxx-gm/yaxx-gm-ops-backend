package org.br.yaxx.backend.services;

import org.br.yaxx.backend.exceptions.UserException;
import org.br.yaxx.backend.models.User;
import org.br.yaxx.backend.models.dtos.UserDTO;
import org.br.yaxx.backend.repositories.UserRepository;
import org.br.yaxx.backend.utils.languagues.ILanguage;
import org.br.yaxx.backend.utils.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    /* VARS */

    private final UserRepository USER_REPOSITORY;

    private final Logger LOGGER;

    private final ILanguage DICTIONARY;

    public UserService(UserRepository userRepository, ILanguage dictionary){
        this.USER_REPOSITORY = userRepository;
        this.LOGGER = LoggerFactory.getLogger(this.getClass());
        this.DICTIONARY = dictionary;
    }

    /* CRUD */

    public User insertUser(UserDTO dto){

        Optional<User> user_optional = getOptionalUserByMail(dto.mail());

        if(user_optional.isPresent())
            throw new UserException(DICTIONARY.getUserAlreadyExist());

        User user;

        try{

            user = UserMapper.createUser(dto);

            USER_REPOSITORY.save(user);

        }catch (Exception e){
            throw new UserException(DICTIONARY.getUserInsertDontWork());
        }

        LOGGER.info(DICTIONARY.getUserSuccessfulInsert());

        return user;
    }

    public User getUserByMail(String mail){

        Optional<User> user_optional = getOptionalUserByMail(mail);

        if(user_optional.isEmpty())
            throw new UserException(DICTIONARY.getUserNoExist());

        return user_optional.get();
    }

    public User editUserByMail(UserDTO dto){

        Optional<User> user_optional = getOptionalUserByMail(dto.mail());

        if(user_optional.isEmpty())
            throw new UserException(DICTIONARY.getUserNoExist());

        User user_update = UserMapper.alterUser(user_optional.get(), dto);

        USER_REPOSITORY.saveAndFlush(user_update);

        return user_update;
    }

    public User deleteUser(String mail){

        Optional<User> user = getOptionalUserByMail(mail);

        if(user.isEmpty())
            throw new UserException(DICTIONARY.getUserNoExist());

        User user_delete = user.get();

        USER_REPOSITORY.delete(user_delete);

        return user_delete;
    }

    /* PRIVATE METHODS */

    private Optional<User> getOptionalUserByMail(String mail){
        return USER_REPOSITORY.getUserByMail(mail);
    }
}
