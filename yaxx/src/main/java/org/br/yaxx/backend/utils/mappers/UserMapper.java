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

}
