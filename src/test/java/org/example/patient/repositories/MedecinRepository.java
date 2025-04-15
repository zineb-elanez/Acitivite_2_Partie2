package org.example.patient.repositories;

import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
