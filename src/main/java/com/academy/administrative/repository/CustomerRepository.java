package com.academy.administrative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academy.administrative.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByDocumentNumber(int dn);
}
