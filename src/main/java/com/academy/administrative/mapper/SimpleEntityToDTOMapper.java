package com.academy.administrative.mapper;

import com.academy.administrative.dto.CustomerDTO;
import com.academy.administrative.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SimpleEntityToDTOMapper {

    CustomerDTO personToCustomerDTO(Person person);

    @Mapping(target = "personId", ignore = true)
    Person custormerDTOtoPerson(CustomerDTO customerDTO);
}
