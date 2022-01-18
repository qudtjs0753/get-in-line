package com.example.getinline.domain;

import com.example.getinline.constant.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: kbs
 */
@Data
public class Event {
    private Long id;

    private Long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
