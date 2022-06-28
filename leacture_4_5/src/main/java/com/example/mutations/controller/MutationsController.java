package com.example.mutations.controller;

import com.example.mutations.entity.Customer;
import com.example.mutations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



@Controller
public class MutationsController {

    @Autowired
    CustomerRepository customerRepository;

    @QueryMapping
    Customer customerById(@Argument Long id) {
        return customerRepository.findById(id).get();
    };

//    @SchemaMapping(typeName="Mutation", field = "addCustomer")
    @MutationMapping
    Customer addCustomer(@Argument String name) {
        return customerRepository.save(new Customer(name));
    };
}
