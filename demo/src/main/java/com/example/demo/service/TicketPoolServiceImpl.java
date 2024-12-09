package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TicketPool;
import com.example.demo.repository.TicketPoolRepository;
@Service
public class TicketPoolServiceImpl implements TicketPoolService {

    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    @Override
    public List<TicketPool> getAllTicketPools() {
        return ticketPoolRepository.findAll();
    }

    @Override
    public TicketPool createTicketPool(TicketPool ticketPool) {
        return ticketPoolRepository.save(ticketPool);
    }

}