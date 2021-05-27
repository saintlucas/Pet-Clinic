package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.controller.model.PetForm;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.service.OwnerService;
import pl.sdacademy.petclinic.service.PetService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetHtmlController {

    private final PetService petService;
    private final OwnerService ownerService;

    @GetMapping("/html/pet/list")
    public String getAllPets(Model model) {
        List<Pet> pets = petService.findAll();
        model.addAttribute("pets", pets);
        return "pet/list";
    }

    @GetMapping("/html/pet/add")
    public String addPetForm(Model model) {
        model.addAttribute("petForm", new PetForm());
        model.addAttribute("owners", ownerService.findAll());

        return "pet/add";
    }

    @PostMapping("/html/pet/add")
    public String addPetForm(@Valid PetForm petForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("petForm", petForm);
            model.addAttribute("owners", ownerService.findAll());
            return "pet/add";
        }

        petService.save(petForm);


        return "redirect:/html/pet/list";
    }

    @GetMapping("/html/pet/edit/{id}")
    public String editPetForm(@PathVariable("id") Long id, Model model) {
        Pet pet = petService.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet does not exist"));
        PetForm petForm = new PetForm(pet);
        model.addAttribute("petForm", petForm);
        model.addAttribute("owners", ownerService.findAll());

        return "pet/edit";
    }

    @PostMapping("/html/pet/edit/{id}")
    public String editPetFormPost(@PathVariable("id") Long id, Model model, @Valid PetForm petForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("petForm", petForm);
            model.addAttribute("owners", ownerService.findAll());
            return "pet/edit";
        }

        petService.update(id, petForm);

        return "redirect:/html/pet/list";
    }

    @GetMapping("/html/pet/delete/{id}")
    public String deletePetForm(@PathVariable("id") Long id, Model model) {
        Pet pet = petService.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet does not exist"));
        String message = String.format("Do you really want to delete %s?", pet.getName());
        model.addAttribute("message", message);

        return "pet/delete";
    }

    @PostMapping("/html/pet/delete/{id}")
    public String deletePetFormPost(@PathVariable("id") Long id) {
        petService.deleteById(id);

        return "redirect:/html/pet/list";
    }


}
