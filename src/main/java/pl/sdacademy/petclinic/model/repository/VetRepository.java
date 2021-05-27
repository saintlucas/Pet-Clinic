package pl.sdacademy.petclinic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.model.Vet;

public interface VetRepository extends JpaRepository<Vet,Long> {
}
