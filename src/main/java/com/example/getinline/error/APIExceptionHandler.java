package com.example.getinline.error;

import com.example.getinline.constant.ErrorCode;
import com.example.getinline.dto.APIErrorResponse;
import com.example.getinline.exception.GeneralException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: kbs
 */

//ResponseEntityExceptionHandler는 spring mvc를 사용하면 생기는 내부적인 에러를 처리하는 로직을 만들어 놓은 클래스.
    //단점: 얘는 body를 만들어서 보내주지를 않음. 에러코드가 예쁘게 나오지가 않는다.
    //internal을 구현하면 된다.
@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e, WebRequest request){
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(e,
                //body부분 원래 null 값인데 따로 넣어줌
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request){
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(e,
                //body부분 원래 null 값인데 따로 넣어줌
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request);
    }

    //Internal override해서 구현
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorCode errorCode = status.is4xxClientError() ?
                ErrorCode.SPRING_BAD_REQUEST :
                ErrorCode.SPRING_INTERNAL_ERROR;

        return super.handleExceptionInternal(ex,
                //body부분 원래 null 값인데 따로 넣어줌
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(ex)),
                headers,
                status,
                request);
    }
}
