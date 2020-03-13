package com.eni.gestionapi_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eni.gestionapi_back.model.Calendrier;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Long>{

}