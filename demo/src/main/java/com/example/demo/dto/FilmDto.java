package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDto {
    private String filmName;
    private String description;
    private LocalDateTime filmStartTime;
    private Long filmHallId;
}
