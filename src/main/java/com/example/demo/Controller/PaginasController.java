package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "usuario/inicio";
    }

    @GetMapping("/anuncio")
    public String mostrarAnuncio() {
        return "usuario/anuncio";
    }

    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "usuario/contacto";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login/login";
    }
}
