package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FilmHall;

@Repository
public interface FilmHallRepository extends JpaRepository <FilmHall,Long>{
    
}
