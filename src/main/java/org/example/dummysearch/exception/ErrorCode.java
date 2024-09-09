package org.example.dummysearch.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_PARAMETER(400, HttpStatus.BAD_REQUEST, "잘못된 매개변수가 포함되었습니다."),
    RESOURCE_NOT_FOUND(404, HttpStatus.NOT_FOUND, "자원을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류가 발생했습니다."),
    ;

    private final int stateCode;
    private final HttpStatus httpStatus;
    private final String message;
}
