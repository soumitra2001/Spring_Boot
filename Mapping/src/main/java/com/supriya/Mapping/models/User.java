package com.supriya.Mapping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Pattern(regexp = "[A-Z][a-z]{2,10}\\D[A-Z][a-z]{1,10}")
    private String userName;
    @Pattern(regexp = "[0-9]+")
    private String age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addressId")
    private Address userAddress;
}
