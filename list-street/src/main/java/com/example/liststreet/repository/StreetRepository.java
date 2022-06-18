package com.example.liststreet.repository;

import com.example.liststreet.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, String > {

}
