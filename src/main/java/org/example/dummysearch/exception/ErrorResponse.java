package org.example.dummysearch.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final int stateCode;
    private final HttpStatus httpStatus;
    private final String message;

    public static ErrorResponse of(final ErrorCode code){
        return new ErrorResponse(code.getStateCode(), code.getHttpStatus(), code.getMessage());
    }
}
