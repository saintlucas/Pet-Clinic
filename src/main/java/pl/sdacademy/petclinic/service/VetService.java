package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.model.repository.PetRepository;
import pl.sdacademy.petclinic.model.repository.VetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;

    public void save(Vet vet){
        vetRepository.save(vet);
    }

    public void save(Vet updatedVet, Long id){
        Vet vetToUpdate = vetRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Vet with such id doesn't exist."));
        vetToUpdate.setName(updatedVet.getName());
        vetRepository.save(vetToUpdate);
    }

    public List<Vet> findAll(){
        return vetRepository.findAll();
    }

    public Optional<Vet> findById(Long id){ return vetRepository.findById(id);}

}
