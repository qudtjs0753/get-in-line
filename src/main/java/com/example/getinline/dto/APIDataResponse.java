package com.example.getinline.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: kbs
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
//에러코드를 정상 코드 안에 상속
//코드를 같이 들고 있어 포멧이 일정해짐.
public class APIDataResponse extends com.example.getinline.dto.APIErrorResponse {

    private final Object data;

    private APIDataResponse(boolean success, Integer errorCode, String message, Object data){
        super(success, errorCode, message);
        this.data = data;
    }

    public static APIDataResponse of(boolean success, Integer errorCode, String message, Object data){
        return new APIDataResponse(success, errorCode, message, data);
    }
}
