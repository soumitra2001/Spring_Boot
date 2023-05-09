package com.geekster.H2dataBase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Users {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="ID")
    private Integer id;

    @NotBlank
    @Pattern(regexp = "[A-Z][A-Za-z\\D]+")
    @Column(name = "user_name",unique = true)
    private String name;

    @NotBlank
    @Email(message = "Invalid email address..!")
    @Column(name = "email_id")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_birth")
    private LocalDate dob;

}
