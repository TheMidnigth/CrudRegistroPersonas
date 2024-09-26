package com.crudpersona.crudspringpersona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudpersona.crudspringpersona.model.PersonaModel;
import com.crudpersona.crudspringpersona.service.PersonaService;

@Controller
@RequestMapping(path = "/Personas")
public class PersonaController {

    /*
     * En las clases  de controlador, se inyecta el servicio que se va a utilizar
     * ya vamos a hacer que los metodos que esten en la clase servicio sean llamados
     * hasta el controlador para darle funcionabilidad
     */
    @Autowired
    private PersonaService personaService;

    /*
     * Ponemos un GetMapping y le pasamos la ruta  que queremos que tenga
     * Creamos un metodo que retornara un String en este caso un html este metodo tambien
     * retornara el metodo listarPersonas  que se encuentra en el servicio este metodo tiene que estar
     * parametrizado con la clase Model y un objeto de esa clase que se encargara de invocar a los metodos
     * de dicha clase usando el objeto model llamamos al metodo addAtribute donde pide dos parametros
     * el primero es el nombre del atriibuto le podemos pasar cualquiera y el segundo sera el valor del atributo
     * donde le tenemos que pasar los metodos de la clase service en este caso fue el metodo listasPersonas
     */
    @GetMapping("/listaPersonas")
    public String listaPersonas(Model model){
        model.addAttribute("people", personaService.listarPersonas());
        return "listaPersonas";
    }

    /*
     * Creamos un metodo llamado registrarPersonas que retornara el html registroPersonas
     * Hacemos lo mismo que en el anterior metodo la unica diferencia que tenemos que
     * instanciar la clase PersonaModel y el objeto de esa clase  pasarla como parametro al metodo addAtribute
     * en el valor del atributo
     */
    @GetMapping("/registroPersonas")
    public String registroPersonas(Model model){
        model.addAttribute("peoples", new PersonaModel());
        return "registroPersona";
    }

    @PostMapping("/guardarPersonas")
    public String guardarPersona(PersonaModel personaModel){
        personaService.guardarPersona(personaModel);
        return "redirect:/Personas/listaPersonas";
    }


}
