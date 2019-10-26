package com.budzynska.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Data
@ResponseStatus(value = BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {

    public ArgumentNotValidException(String message) {
        super(message);
    }
}
