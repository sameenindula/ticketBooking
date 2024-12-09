package com.example.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketPoolDto {
    private List<Long> filmIds;
    private String seatNo;
    private Long price;
    private Boolean availability;
}
