package hackerton.be.domain.subject.exception;

import hackerton.be.global.exception.BaseException;
import hackerton.be.global.exception.BaseExceptionType;

public class SubjectException extends BaseException {
    private final BaseExceptionType exceptionType;

    public SubjectException(BaseExceptionType exceptionType){
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
