package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FilmDto;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmHall;
import com.example.demo.service.FilmHallService;
import com.example.demo.service.FilmService;

@RestController
@CrossOrigin(origins = "*")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmHallService filmHallService;

    // Get all films with filmHallId in the response
    @GetMapping("/film")
    public ResponseEntity<List<FilmDto>> getFilms() {
        List<FilmDto> film = filmService.getAllFilms();
        return ResponseEntity.status(200).body(film);
    }

    // Create a new film with a given FilmDto (includes filmHallId)
    @PostMapping("/film")
    public ResponseEntity<Film> createFilm(@RequestBody FilmDto filmDto) {
        Film film = new Film();
        film.setFilmName(filmDto.getFilmName());
        film.setDescription(filmDto.getDescription());
        film.setFilmStartTime(filmDto.getFilmStartTime());

        // Fetch the FilmHall by filmHallId from FilmDto
        FilmHall filmHall = filmHallService.getFilmHallById(filmDto.getFilmHallId());
        if (filmHall == null) {
            return ResponseEntity.status(404).body(null);  // Return 404 if FilmHall not found
        }
        film.setFilmHall(filmHall);

        Film createdFilm = filmService.createFilm(film);
        return ResponseEntity.status(201).body(createdFilm);
    }

    // Update a film by id (with filmHallId from FilmDto)
    @PutMapping("/film/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody FilmDto filmDto) {
        Film film = new Film();
        film.setFilmName(filmDto.getFilmName());
        film.setDescription(filmDto.getDescription());
        film.setFilmStartTime(filmDto.getFilmStartTime());

        // Fetch the FilmHall by filmHallId from FilmDto
        FilmHall filmHall = filmHallService.getFilmHallById(filmDto.getFilmHallId());
        if (filmHall == null) {
            return ResponseEntity.status(404).body(null);  // Return 404 if FilmHall not found
        }
        film.setFilmHall(filmHall);

        Film updatedFilm = filmService.updateFilm(id, film);
        if (updatedFilm == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(updatedFilm);
    }

    // Delete a film by id
    @DeleteMapping("/film/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.status(200).body("Film deleted successfully.");
    }
}
