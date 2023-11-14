package org.br.yaxx.backend.utils.mappers;

import org.br.yaxx.backend.models.User;
import org.br.yaxx.backend.models.dtos.UserDTO;

public class UserMapper {

    public static User createUser(UserDTO dto){

        return new User(
                dto.mail(),
                dto.password(),
                dto.first_name(),
                dto.last_name()
        );

    }

    public static User alterUser(User user, UserDTO dto){

        user.setFirst_name(dto.first_name());
        user.setLast_name(dto.last_name());
        user.setMail(dto.mail());
        user.setPassword(dto.password());

        return user;
    }

}
