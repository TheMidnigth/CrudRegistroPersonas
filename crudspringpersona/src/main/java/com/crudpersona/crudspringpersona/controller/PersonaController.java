package com.crudpersona.crudspringpersona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/listaPersonas")
    public String listaPersonas(Model model){
        model.addAttribute("people", personaService.listarPersonas());
        return "listaPersonas";
    }

    @GetMapping("/registroPersonas")
    public String registroPersonas(Model model){
        PersonaModel persona = new PersonaModel();
        model.addAttribute("peoples", persona);
        return "registroPersona";
    }

    @PostMapping("/guardarPersonas")
    public String guardarPersona(@ModelAttribute("peoples") PersonaModel personaModel){
        personaService.guardarPersona(personaModel);
        return "redirect:/Personas/listaPersonas";
    }


}
