package pl.sdacademy.petclinic.service;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pl.sdacademy.petclinic.model.Owner;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.model.PetType;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.model.repository.OwnerRepository;
import pl.sdacademy.petclinic.model.repository.PetRepository;
import pl.sdacademy.petclinic.model.repository.VetRepository;

import java.time.LocalDate;@Component
@RequiredArgsConstructor
public class DBPopulatingService implements
        ApplicationListener<ApplicationReadyEvent> {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Owner owner = new Owner();
        owner.setName("John");
        owner.setAddress("Grunwaldzka");
        owner.setCity("Gdansk");
        owner = ownerRepository.save(owner);

        Pet pet = new Pet();
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Burek");
        pet.setPetType(PetType.OTHER);
        petRepository.save(pet);

        Owner owner2 = new Owner();
        owner2.setName("Martin");
        owner2.setAddress("Niepodleglosci");
        owner2.setCity("Gdynia");
        owner2 = ownerRepository.save(owner2);

        Pet pet2 = new Pet();
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Reksio");
        pet2.setPetType(PetType.HEDGEHOG);
        petRepository.save(pet2);

        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vet1.setName("Vet1");
        vet2.setName("Vet2");

        vetRepository.save(vet1);
        vetRepository.save(vet2);
    }
}