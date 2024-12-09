package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TicketPool;

public interface TicketPoolService {
    List<TicketPool> getAllTicketPools();
    TicketPool createTicketPool(TicketPool ticketPool);
}
