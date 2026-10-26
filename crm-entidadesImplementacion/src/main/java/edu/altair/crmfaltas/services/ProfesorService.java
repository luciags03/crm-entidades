
package edu.altair.crmfaltas.services;

import java.util.List;

import edu.altair.crmfaltas.entities.Profesor;

public interface ProfesorService {

    List<Profesor> obtenerTodas();

    Profesor guardar(Profesor profesor);
}
