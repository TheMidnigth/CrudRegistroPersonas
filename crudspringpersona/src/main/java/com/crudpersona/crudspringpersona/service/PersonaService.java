package com.crudpersona.crudspringpersona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudpersona.crudspringpersona.model.PersonaModel;
import com.crudpersona.crudspringpersona.repository.PersonaRepository;

//*En las clases service tenemos que poner las anotaciones de service es obligatorio */
@Service
public class PersonaService {

    /*
     * En la clase service instanciamos las clase repository
     * para poder interactuar con la base de datos
     */
    @Autowired
    private PersonaRepository personaRepository;

    /*
     * Metodo que retornara una lista de persona de la clase
     * PersonaModel
     */
    public List<PersonaModel> listarPersonas(){
        return personaRepository.findAll();
    }


}
