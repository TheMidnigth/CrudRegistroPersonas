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

    /*
     * Metodo para guardar a las personas en la base de datos y en la tabla
     * pasandole como parametro la clase model y utilizando el objeto de personaRepository
     * para invocar  el metodo save para guardar a una persona
     */
    public PersonaModel guardarPersona(PersonaModel personaModel){
        return personaRepository.save(personaModel);
    }

    /*
     * Metodo para buscar a una persona por id este metodo retorna un objeto de tipo PersonaModel
     * de la clase  PersonaModel tiene que estar parametrizao con  el id de la persona y con el objeto
     * de la clase  PersonaRepository para poder invocar el metodo findById que  es el que nos permite
     *   buscar a una persona por id
     */
    public PersonaModel buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    /*
     * Metodo para actualizar el estado de una persona este metodo retorna un objeto de tipo PersomaModel
     * de la clase PersonaModel esta parametrizado con la clase PersonaModel y un  objeto de esa clase
     * utilizamos el objeto de la clase PersonaRepository para poder invocar el metodo save para guardar y actualizar a una persona
     * pasandole como parametro el objeto de la clase PersonaModel
     */
    public PersonaModel actualizarPersona(PersonaModel personaModel){
        return personaRepository.save(personaModel);
    }

    /*
     * Metodo para eliminar a una persona este metodo  no retorna nada esta parametrizado con el id de la personas
     *  y utilizando el objeto de la clase PersonaRepository  para poder invocar el metodo deleteById para eliminar a una persona
     */
    public void  eliminarPersona(Long id){
        personaRepository.deleteById(id);
    }


}
