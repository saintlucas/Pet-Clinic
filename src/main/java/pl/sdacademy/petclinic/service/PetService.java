package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.controller.model.PetForm;
import pl.sdacademy.petclinic.model.Owner;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.model.repository.OwnerRepository;
import pl.sdacademy.petclinic.model.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public void addNew(Pet pet, Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner with such id doesn't exist"));
        pet.setOwner(owner);
        petRepository.save(pet);
    }

    public void save(PetForm petForm) {
        Pet pet = new Pet();
        pet.setName(petForm.getName());
        pet.setBirthDate(petForm.getBirthDate());
        pet.setPetType(petForm.getPetType());
        Owner owner = ownerRepository.findById(petForm.getOwnerId()).orElse(null);
        pet.setOwner(owner);

        petRepository.save(pet);
    }

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public void save(Pet updatedPet, Long petID) {
        Pet petToUpdate = petRepository.findById(petID)
                .orElseThrow(() -> new IllegalArgumentException("Pet with such id doesn't exist."));
        petToUpdate.setName(updatedPet.getName());
        petToUpdate.setBirthDate(updatedPet.getBirthDate());
        petToUpdate.setPetType(updatedPet.getPetType());
        petToUpdate.setOwner(updatedPet.getOwner());
        petRepository.save(petToUpdate);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    public void update(Long id, PetForm petForm) {
        Pet petToUpdate = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet does not exist"));
        Owner owner = ownerRepository.findById(petForm.getOwnerId()).orElseThrow(() -> new IllegalArgumentException("Owner does not exist"));

        petToUpdate.setName(petForm.getName());
        petToUpdate.setPetType(petForm.getPetType());
        petToUpdate.setBirthDate(petForm.getBirthDate());
        petToUpdate.setOwner(owner);

        petRepository.save(petToUpdate);
    }

    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
