
package edu.altair.crmfaltas.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.altair.crmfaltas.entities.Profesor;
import edu.altair.crmfaltas.repositories.FaltaRepository;
import edu.altair.crmfaltas.services.ProfesorService;

@Service
public class FaltaServiceImpl implements ProfesorService {

    private final FaltaRepository faltaRepository;

    public FaltaServiceImpl(FaltaRepository faltaRepository) {
        this.faltaRepository = faltaRepository;
    }

    @Override
    public List<Profesor> obtenerTodas() {
        return faltaRepository.findAll();
    }

    @Override
    public Profesor guardar(Profesor profesor) {
        return faltaRepository.save(profesor);
    }
}
