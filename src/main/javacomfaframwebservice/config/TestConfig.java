package com.fafram.webserviceApplication.config;

import com.fafram.webserviceApplication.entities.Customer;
import com.fafram.webserviceApplication.entities.Phone;
import com.fafram.webserviceApplication.repositories.CustomerRepository;
import com.fafram.webserviceApplication.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    
    @Autowired
    private PhoneRepository phoneRepository;

   
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {

        Phone pho1 = new Phone(null,"celular", 23556768);
        Phone pho2 = new Phone(null,"celular", 23578000);
        Phone pho3 = new Phone(null,"celular", 4669354);

        Customer customer1 = new Customer(null,"Wagner","abc", "346851");
        Customer customer2 = new Customer(null,"Pedro","def", "46690875");
        Customer customer3 = new Customer(null,"Carlos","ghi", "446680878");

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        phoneRepository.saveAll(Arrays.asList(pho1, pho2, pho3));

        customer1.getPhones().add(pho1);
        customer1.getPhones().add(pho2);

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));

    }
}