package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.service.PetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping("/pet/add")
    public void addPet(@RequestBody Pet pet, @RequestParam(name = "ownerId") Long ownerId){
        petService.addNew(pet,ownerId);
    }

    @GetMapping("/pet/list")
    public List<Pet> getAllPets(){
        return petService.findAll();
    }


}
