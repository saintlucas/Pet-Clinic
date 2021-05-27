package pl.sdacademy.petclinic.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnimalController {

	private final AnimalService animalService;

	@GetMapping("/list")
	public List<Animal> list() {
		return animalService.findAnimals();
	}

	@GetMapping("/by-name")
	public List<Animal> list(@RequestParam("name") String name) {
		return animalService.findAnimalByName(name);
	}
}
