package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.model.Owner;
import pl.sdacademy.petclinic.model.Vet;
import pl.sdacademy.petclinic.service.OwnerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping ("/owner/add")
    public void addOwner(@RequestBody Owner owner){
        ownerService.save(owner);
    }

    @GetMapping("/owner/list")
    public List<Owner> getAllOwners(){
        return ownerService.findAll();
    }

    @PostMapping("owner/update")
    public void updateVet(@RequestBody Owner owner, @RequestParam(name = "vetId") Long ownerId){
        ownerService.save(owner,ownerId);
    }
}
