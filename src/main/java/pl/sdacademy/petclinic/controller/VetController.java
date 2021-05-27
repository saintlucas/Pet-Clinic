package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.service.VetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;

    @PostMapping("vet/add")
    public void addVet(@RequestBody Vet vet){
        vetService.save(vet);
    }

    @GetMapping("vet/list")
    public List<Vet> getAllVets(){
        return vetService.findAll();
    }

    @PostMapping("vet/update")
    public void updateVet(@RequestBody Vet vet, @RequestParam(name = "vetId") Long vetId){
        vetService.save(vet,vetId);
    }
}
