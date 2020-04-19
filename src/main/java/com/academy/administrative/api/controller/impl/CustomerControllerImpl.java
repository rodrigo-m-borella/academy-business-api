package com.academy.administrative.api.controller.impl;

import com.academy.administrative.api.controller.CustomerController;
import com.academy.administrative.dto.CustomerDTO;
import com.academy.administrative.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

    CustomerService customerService;

    @Override
    @GetMapping(value = "/list")
    public List<CustomerDTO> getAllCustomerList() {
        return customerService.getCustomerList();
    }

    @Override
    @PostMapping
    public CustomerDTO customer(@RequestBody  CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) { this.customerService = customerService; }

}

