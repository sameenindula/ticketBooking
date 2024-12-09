package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.FilmHall;

public interface FilmHallService {
    List <FilmHall> getAllFilmHalls();
    FilmHall createFilmHall(FilmHall filmHall);
    FilmHall getFilmHallById(Long Id);

}
