package hackerton.be.domain.recommend.exception;

import hackerton.be.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum RecommendExceptionType implements BaseExceptionType {
    EMPTY_RECOMMENDATION_LIST(800, HttpStatus.BAD_REQUEST, "추천 목록이 비어 있습니다."),
    NO_RECOMMENDATIONS_FOUND(801, HttpStatus.NOT_FOUND, "추천 데이터가 없습니다.");

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    RecommendExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
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
