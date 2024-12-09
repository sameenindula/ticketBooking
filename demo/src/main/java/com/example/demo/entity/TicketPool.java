package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TicketPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String seatNo;
    private Long price;
    private Boolean availability;

    @ManyToMany
    @JoinTable(
        name = "ticketPool_film",
        joinColumns = @JoinColumn(name = "ticketId"),
        inverseJoinColumns = @JoinColumn(name = "filmId")
    )
    private List<Film> ticketFilm;

}
