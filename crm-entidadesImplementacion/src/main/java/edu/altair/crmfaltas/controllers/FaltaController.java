
package edu.altair.crmfaltas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.altair.crmfaltas.entities.Profesor;
import edu.altair.crmfaltas.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class FaltaController {

    private final ProfesorService profesorService;

    public FaltaController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    // GET /api/profesores: devuelve todos los profesores
    @GetMapping
    public List<Profesor> obtenerTodas() {
        return profesorService.obtenerTodas();
    }

    // POST /api/profesores: registra un profesor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesor guardar(@RequestBody Profesor profesor) {
        return profesorService.guardar(profesor);
    }
}
