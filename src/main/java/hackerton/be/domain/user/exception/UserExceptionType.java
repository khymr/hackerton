package hackerton.be.domain.user.exception;

import hackerton.be.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum UserExceptionType implements BaseExceptionType {
    USER_NOT_FOUND(900, HttpStatus.NOT_FOUND, "사용자가 존재하지 않습니다.");

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    UserExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
