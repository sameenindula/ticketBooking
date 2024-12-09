package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Film;

public interface FilmService {
    List<Film> getFilmsByIds(List<Long> filmIds);
    List<FilmDto> getAllFilms();
    Film createFilm(Film film);
    Film updateFilm(Long id, Film film);
    void deleteFilm(Long id);
    Film getFilmById(Long id);
}
