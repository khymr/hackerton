package hackerton.be.domain.recommend.exception;

import hackerton.be.global.exception.BaseException;
import hackerton.be.global.exception.BaseExceptionType;

public class RecommendException extends BaseException {
    private final BaseExceptionType exceptionType;

    public RecommendException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return this.exceptionType;
    }
}
