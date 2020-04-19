package com.academy.administrative.service;

import com.academy.administrative.dto.CustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
public interface CustomerService {

    List<CustomerDTO> getCustomerList();

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}
