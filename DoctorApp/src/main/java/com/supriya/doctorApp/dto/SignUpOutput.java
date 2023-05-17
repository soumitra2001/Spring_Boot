package com.supriya.doctorApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class SignUpOutput {

    @Nullable
    public String message;

    public HttpStatus status;
}
