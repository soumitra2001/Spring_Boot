package com.supriya.StockManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;

    @NotBlank
    @Column(unique = true)
    private String stockName;

    @NotNull
    private Double stockPrice;

    private Integer stockOwner;

    @DateTimeFormat(pattern = "YY/MM/DD")
    private LocalDate releasedDate;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z0-9]+")
    private String stockType;

}
