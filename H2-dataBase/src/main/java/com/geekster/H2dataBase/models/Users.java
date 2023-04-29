package com.geekster.H2dataBase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

@Column(name = "user_name",unique = true)
    private String name;

@Column(name = "email_id")
    private String email;

@Column(name = "date_of_birth")
    private LocalDate dob;
}
