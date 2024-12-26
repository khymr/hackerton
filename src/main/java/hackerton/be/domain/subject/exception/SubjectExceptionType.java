package hackerton.be.domain.subject.exception;

import hackerton.be.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum SubjectExceptionType implements BaseExceptionType {
    NO_DEPARTMENTS_FOUND(700, HttpStatus.NOT_FOUND, "학과 정보가 없습니다."),
    NO_SUBJECTS_FOUND(701, HttpStatus.NOT_FOUND, "해당 학과의 과목 정보가 없습니다."),
    SUBJECT_NOT_FOUND(901, HttpStatus.NOT_FOUND, "과목이 존재하지 않습니다.");
    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    SubjectExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
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
