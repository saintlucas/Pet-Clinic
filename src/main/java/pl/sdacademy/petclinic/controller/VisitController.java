package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.model.Visit;
import pl.sdacademy.petclinic.service.VisitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/visit/list")
    public List<Visit> getAllVisits(){
        return visitService.findAll();
    }

    @PostMapping("/visit/add")
    public void addVisit(@RequestBody String description, @RequestParam(name = "vetId") Long vetId,
                         @RequestParam(name = "petId") Long petId){
        visitService.addNewVisit(description,petId,vetId);
    }
}
