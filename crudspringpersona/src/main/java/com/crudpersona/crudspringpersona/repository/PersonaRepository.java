package com.crudpersona.crudspringpersona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudpersona.crudspringpersona.model.PersonaModel;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaModel,Long> {

}
