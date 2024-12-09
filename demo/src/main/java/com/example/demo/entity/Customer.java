// package com.example.demo.entity;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Getter
// @Setter
// public class Customer {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
//     private String cusName;
//     private long seats;
//     private long totalPrice;

//     @JsonIgnore
//     @OneToMany(mappedBy = "customer") // Customer is the "many" side of this relationship
//     private List<TicketPool> ticketPool;
// }
