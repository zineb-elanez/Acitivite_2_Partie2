package org.example.patient.repositories;

import org.example.patient.entities.Consultation;
import org.example.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
