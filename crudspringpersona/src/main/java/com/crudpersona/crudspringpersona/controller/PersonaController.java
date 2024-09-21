package com.crudpersona.crudspringpersona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/listaPersonas")
    public String listaPersonas(Model model){
        model.addAttribute("people", personaService.listarPersonas());
        return "listaPersonas";
    }

}
