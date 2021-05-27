package pl.sdacademy.petclinic.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.example.Animal;
import pl.sdacademy.petclinic.model.repository.AnimalRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimalService {

	private final AnimalRepository animalRepository;

	public List<Animal> findAnimals() {
		return animalRepository.findAll();
	}

	public List<Animal> findAnimalByName(String name) {
		return animalRepository.findAllByName(name);
	}
}
