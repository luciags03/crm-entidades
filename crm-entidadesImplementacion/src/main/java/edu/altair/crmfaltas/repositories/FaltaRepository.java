
package edu.altair.crmfaltas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.crmfaltas.entities.Profesor;

@Repository
public interface FaltaRepository extends JpaRepository<Profesor, Long> {
}
