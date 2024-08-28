package com.samsung.tddtest.services;

import com.samsung.tddtest.repositories.CustomerRepository;
import com.samsung.tddtest.repositories.models.Customer;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {
    CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public String createCustomer(Customer customer) {
        Customer cus = customerRepo.getCustomerByEmail(customer.Email);
        Pattern pattern = Pattern.compile("[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        Matcher matcher = pattern.matcher(customer.Email);
        if (!matcher.find())
            return "Email is invalid";
        if (cus != null)
            return "Email is already existed";
        if (customerRepo.createcustomer(customer))
            return "Created successfully";
        return "Creating failed";
    }
}