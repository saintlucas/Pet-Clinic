package pl.sdacademy.petclinic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
