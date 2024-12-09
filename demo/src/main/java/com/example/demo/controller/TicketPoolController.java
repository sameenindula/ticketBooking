package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TicketPoolDto;
import com.example.demo.entity.Film;
import com.example.demo.entity.TicketPool;
import com.example.demo.service.FilmService;
import com.example.demo.service.TicketPoolService;



@RestController
@CrossOrigin(origins = "*")
public class TicketPoolController {

    @Autowired
    private TicketPoolService ticketPoolService;

    @Autowired
    private FilmService filmService;



    @GetMapping("/ticket")
    public ResponseEntity<List<TicketPool>>  getAllTicketPool() {
        List<TicketPool> ticketPools=ticketPoolService.getAllTicketPools();
        return ResponseEntity.status(200).body(ticketPools);
    }

    @PostMapping("/ticket")
        public ResponseEntity<TicketPool> createTicketPool(@RequestBody TicketPoolDto ticketPoolDto) {
            // Validate the incoming TicketPoolDto
            if (ticketPoolDto.getFilmIds() == null || ticketPoolDto.getFilmIds().isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }

            // Fetch associated films
            List<Film> films = filmService.getFilmsByIds(ticketPoolDto.getFilmIds());
            if (films.isEmpty()) {
                return ResponseEntity.badRequest().body(null); // No films found for the given IDs
            }

            // Create and populate TicketPool
            TicketPool ticketPool = new TicketPool();
            ticketPool.setSeatNo(ticketPoolDto.getSeatNo());
            ticketPool.setPrice(ticketPoolDto.getPrice());
            ticketPool.setAvailability(ticketPoolDto.getAvailability());
            ticketPool.setTicketFilm(films);

            // Save the TicketPool entity
            TicketPool savedTicketPool = ticketPoolService.createTicketPool(ticketPool);

            // Return the saved entity
            return ResponseEntity.status(201).body(savedTicketPool);
        }
    
    

}
