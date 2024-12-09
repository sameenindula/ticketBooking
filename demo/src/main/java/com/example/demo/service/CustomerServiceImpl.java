// package com.example.demo.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Customer;
// import com.example.demo.repository.CustomerRepository;

// @Service
// public class CustomerServiceImpl implements CustomerService {

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Override
//     public List<Customer> getAllCustomers() {
//         return customerRepository.findAll();
//     }

//     @Override
//     public Customer createCustomer(Customer customer) {
//         return customerRepository.save(customer);
//     }

//     @Override
//     public Customer updateCustomer(Long id, Customer customer) {
//         Customer existingCustomer = customerRepository.findById(id).orElse(null);

//         if (existingCustomer == null) {
//             return null; // Return null if the customer with given id doesn't exist
//         } else {
//             existingCustomer.setCusName(customer.getCusName());
//             existingCustomer.setSeats(customer.getSeats());
//             existingCustomer.setTotalPrice(customer.getTotalPrice());
//             existingCustomer.setTicketPool(customer.getTicketPool());
//             return customerRepository.save(existingCustomer);
//         }
//     }

//     @Override
//     public Customer getCustomerById(Long id) {
//         return customerRepository.findById(id).orElse(null); // Return null if not found
//     }

//     @Override
//     public void deleteCustomer(Long id) {
//         customerRepository.deleteById(id);
//     }
// }
