package com.academy.administrative.api.controller;

import com.academy.administrative.dto.CustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
@Api(tags ={"customer"})
public interface CustomerController {

    @ApiOperation(value = "Retorna lista de customer.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    List<CustomerDTO> getAllCustomerList();

    @ApiOperation(value = "Guarda el customer enviado por request.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    CustomerDTO customer(CustomerDTO customerDTO);
}
