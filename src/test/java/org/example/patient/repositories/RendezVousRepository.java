package org.example.patient.repositories;

import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,/* Long*/ String> {
}
