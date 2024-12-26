package hackerton.be.domain.user.exception;

import hackerton.be.global.exception.BaseException;
import hackerton.be.global.exception.BaseExceptionType;

public class UserException extends BaseException {
    private final BaseExceptionType exceptionType;

    public UserException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return this.exceptionType;
    }
}
