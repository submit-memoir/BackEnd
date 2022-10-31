package com.example.memoir.global.entity;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

public class BaseTimeEntity extends BaseIdEntity {

    @LastModifiedDate
    private LocalDate modifiedAt;
}
