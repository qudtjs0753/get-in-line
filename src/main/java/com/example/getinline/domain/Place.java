package com.example.getinline.domain;

import com.example.getinline.constant.PlaceType;

import java.time.LocalDateTime;

/**
 * @Author: kbs
 */
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private String capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
