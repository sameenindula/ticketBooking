package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FilmHall;
import com.example.demo.service.FilmHallService;



@RestController
@CrossOrigin(origins = "*")
public class FilmHallController {
    @Autowired
    private FilmHallService filmHallService;

    @GetMapping("/filmHall")
    public ResponseEntity <List<FilmHall>> getFilmHalls () {
        List<FilmHall> filmHall= filmHallService.getAllFilmHalls();
        return ResponseEntity.status(200).body(filmHall);
    }

    @PostMapping("/filmHall")
    public ResponseEntity<FilmHall> createFilmHall(@RequestBody FilmHall filmHall) {
        FilmHall createFilmHall=filmHallService.createFilmHall(filmHall);
        return ResponseEntity.status(201).body(createFilmHall);
    }
    
    
}
