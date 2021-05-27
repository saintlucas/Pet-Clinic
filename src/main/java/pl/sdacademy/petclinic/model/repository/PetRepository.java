package pl.sdacademy.petclinic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
