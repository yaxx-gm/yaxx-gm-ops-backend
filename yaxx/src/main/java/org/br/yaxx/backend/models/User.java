package org.br.yaxx.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    public User(String mail, String password, String first_name, String last_name) {
        this.mail = mail;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
