package com.catalogue.gamecatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
    private long id;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    private String username;
    @NotBlank
    private String password;
    private boolean valid;
    @Basic
    private Date createdAt = new Date();
}
