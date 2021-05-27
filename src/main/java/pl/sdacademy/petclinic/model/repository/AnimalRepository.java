package pl.sdacademy.petclinic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.example.Animal;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	List<Animal> findAllByName(String name);
}
