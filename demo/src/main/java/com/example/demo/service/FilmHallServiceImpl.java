package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FilmHall;
import com.example.demo.repository.FilmHallRepository;

@Service
public class FilmHallServiceImpl implements FilmHallService{

    @Autowired
    private FilmHallRepository filmHallRepository;

    @Override
    public List<FilmHall> getAllFilmHalls() {
        return filmHallRepository.findAll();
    }

    @Override
    public FilmHall createFilmHall(FilmHall filmHall) {
        return filmHallRepository.save(filmHall);
    }

    @Override
    public FilmHall getFilmHallById(Long Id) {
        return filmHallRepository.findById(Id).orElse(null);
    }
    
}
