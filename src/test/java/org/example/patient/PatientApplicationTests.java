package org.example.patient;

import org.example.patient.entities.*;
import org.example.patient.repositories.ConsultationRepository;
import org.example.patient.repositories.MedecinRepository;
import org.example.patient.repositories.PatientRepository;
import org.example.patient.repositories.RendezVousRepository;
import org.example.patient.service.IHospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
class PatientApplicationTests {
 public static void main(String[] args) {
     SpringApplication.run(PatientApplicationTests.class, args);
 }
@Bean
CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,
                        RendezVousRepository rendezVousRepository,
                        ConsultationRepository consultationRepository,
                        MedecinRepository medecinRepository) {
     return args -> {
Stream.of("hassan","najat","ahmed").
        forEach(name -> {
            Patient patient = new Patient();
            patient.setNom(name);
            patient.setDatenaissance(new Date());
            patient.setMalade(false);
            hospitalService.savePatient(patient);
        });


         Stream.of("ghita","anas","doha").
                 forEach(name -> {
                     Medecin medecin = new Medecin();
                     medecin.setNom(name);
                     medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                     medecin.setEmail(name+"@gmail.com");
                     hospitalService.saveMedecin(medecin);
                 });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("hassan");


            Medecin medecin=medecinRepository.findByNom("ghita");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

//RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
         RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
         Consultation consultation=new Consultation();
         consultation.setDateConsultation(rendezVous1.getDate());
         consultation.setRendezVous(rendezVous1);
         consultation.setRapport("rapport de la consultation........");
         hospitalService.saveConsultation(consultation);
     };
}

}
