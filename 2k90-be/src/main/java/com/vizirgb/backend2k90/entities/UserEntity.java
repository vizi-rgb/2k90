package com.vizirgb.backend2k90.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String login;

    private String email;

    private String password;

    private String role;

    @Column(columnDefinition = "bool not null default true")
    private boolean enabled;

    public UserEntity(
            String login,
            String email,
            String password
    ) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = "USER";
        this.enabled = true;
    }

}
