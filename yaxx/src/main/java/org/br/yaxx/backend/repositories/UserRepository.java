package org.br.yaxx.backend.repositories;

import org.br.yaxx.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(
            "SELECT U " +
            "FROM User AS U " +
            "WHERE U.mail = :mail"
    )
    Optional<User> getUserByMail(@Param("mail") String mail);

}
