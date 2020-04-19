package com.academy.administrative.service.impl;

import com.academy.administrative.dto.CustomerDTO;
import com.academy.administrative.entity.Person;
import com.academy.administrative.mapper.SimpleEntityToDTOMapper;
import com.academy.administrative.repository.CustomerRepository;
import com.academy.administrative.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    SimpleEntityToDTOMapper simpleEntityToDTOMapper;

    @Override
    public List<CustomerDTO> getCustomerList() {
        List<Person> personList = customerRepository.findAll();
        List<CustomerDTO> responseList = new ArrayList<>();

        personList.stream()
                .forEach(
                        c -> {
                            responseList.add(simpleEntityToDTOMapper.personToCustomerDTO(c));
                        }
                );

        return responseList;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {

        customerRepository.findByDocumentNumber(customerDTO.getDocumentNumber())
                .ifPresent(
                        c -> {
                            throw new IllegalArgumentException("El siguiente documento ya existe: "+ Integer.toString(c.getDocumentNumber()));
                        }
                );

        Person person = simpleEntityToDTOMapper.custormerDTOtoPerson(customerDTO);
        customerRepository.save(person);
        return null;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setSimpleEntityToDTOMapper(SimpleEntityToDTOMapper simpleEntityToDTOMapper) {
        this.simpleEntityToDTOMapper = simpleEntityToDTOMapper;
    }
}
