package com.supriya.Mapping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @NotBlank
    private String city;
    @Pattern(regexp = "[A-Za-z]+\\D[0-9]+")
    private String houseNo;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userAddress")
    private List<User> user;

}
