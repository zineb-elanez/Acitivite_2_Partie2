package org.example.patient.service;

import jakarta.transaction.Transactional;
import org.example.patient.entities.Consultation;
import org.example.patient.entities.Medecin;
import org.example.patient.entities.Patient;
import org.example.patient.entities.RendezVous;
import org.example.patient.repositories.ConsultationRepository;
import org.example.patient.repositories.MedecinRepository;
import org.example.patient.repositories.PatientRepository;
import org.example.patient.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HopitalServiceImpl implements IHospitalService {

private PatientRepository patientRepository;
private MedecinRepository medecinRepository;

    public HopitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    private RendezVousRepository rendezVousRepository;
private ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }


    /*@Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }*/

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
