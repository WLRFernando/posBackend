package com.ijse.pos.pos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Data
@AllArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
