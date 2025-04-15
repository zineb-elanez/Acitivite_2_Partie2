package org.example.patient.service;

import org.example.patient.entities.Consultation;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;


public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
