package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmHall;
import com.example.demo.repository.FilmHallRepository;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmHallRepository filmHallRepository;

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        // Convert each Film entity to FilmDto
        return films.stream()
                    .map(this::convertToFilmDto)
                    .collect(Collectors.toList());
    }

    // Helper method to convert Film to FilmDto
    private FilmDto convertToFilmDto(Film film) {
        FilmDto filmDto = new FilmDto();
        filmDto.setFilmName(film.getFilmName());
        filmDto.setDescription(film.getDescription());
        filmDto.setFilmStartTime(film.getFilmStartTime());
        
        // Set the filmHallId from the Film entity
        if (film.getFilmHall() != null) {
            filmDto.setFilmHallId(film.getFilmHall().getId());
        }

        return filmDto;
    }

    @Override
    public Film createFilm(Film film) {
        if (film.getFilmHall() != null) {
            // Ensure film hall is set properly
            FilmHall filmHall = filmHallRepository.findById(film.getFilmHall().getId())
                .orElseThrow(() -> new RuntimeException("Film hall not found"));
            film.setFilmHall(filmHall);
        }
        return filmRepository.save(film);
    }

    @Override
    public Film updateFilm(Long id, Film film) {
        Film existingFilm = filmRepository.findById(id).orElse(null);

        if (existingFilm == null) {
            return null;
        } else {
            existingFilm.setFilmName(film.getFilmName());
            existingFilm.setDescription(film.getDescription());
            existingFilm.setFilmStartTime(film.getFilmStartTime());
            existingFilm.setFilmHall(film.getFilmHall());
            return filmRepository.save(existingFilm);
        }
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public List<Film> getFilmsByIds(List<Long> filmIds) {
        return filmRepository.findAllById(filmIds);
    }
}
