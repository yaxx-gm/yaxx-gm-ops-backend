package org.br.yaxx.backend.models.dtos;

public record UserDTO(

        String mail,
        String password,
        String first_name,
        String last_name

) {}
