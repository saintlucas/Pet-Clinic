package pl.sdacademy.petclinic.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.petclinic.model.Owner;
import pl.sdacademy.petclinic.model.Pet;
import pl.sdacademy.petclinic.model.PetType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PetForm {

    public PetForm(Pet pet) {
        this.name = pet.getName();
        this.birthDate = pet.getBirthDate();
        this.petType = pet.getPetType();
        this.ownerId = pet.getOwner().getId();
    }

    @NotEmpty
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private PetType petType;
    private Long ownerId;
}
