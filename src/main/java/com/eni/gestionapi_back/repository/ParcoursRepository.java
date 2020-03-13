package com.eni.gestionapi_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eni.gestionapi_back.model.Parcours;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, Long>{

}