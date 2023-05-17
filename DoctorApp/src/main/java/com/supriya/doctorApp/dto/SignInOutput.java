package com.supriya.doctorApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class SignInOutput {

    @Nullable
    private String message;

    private String token;

}
