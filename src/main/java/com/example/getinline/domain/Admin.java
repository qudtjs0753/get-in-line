package com.example.getinline.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: kbs
 */
@Data
public class Admin {
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
