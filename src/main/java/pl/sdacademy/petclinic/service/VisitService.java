package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.model.Visit;
import pl.sdacademy.petclinic.model.repository.PetRepository;
import pl.sdacademy.petclinic.model.repository.VetRepository;
import pl.sdacademy.petclinic.model.repository.VisitRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;

    public void addNewVisit(String description, Long petId, Long vetId){
        Pet pet = petRepository.findById(petId)
                .orElseThrow(()-> new IllegalArgumentException("Wrong pet id param."));
        Vet vet = vetRepository.findById(vetId)
                .orElseThrow(()-> new IllegalArgumentException("Wrong vet id param."));
        Visit visit = new Visit();
        visit.setVet(vet);
        visit.setPet(pet);
        visit.setDescription(description);
        visit.setDate(LocalDate.now());
        visitRepository.save(visit);
    }

    public void save(Visit visit){
        visitRepository.save(visit);
    }

    public List<Visit> findAll(){
        return visitRepository.findAll();
    }

}
