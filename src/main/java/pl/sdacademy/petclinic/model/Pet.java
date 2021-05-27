package pl.sdacademy.petclinic.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    @ManyToOne
    private Owner owner;



}
/*
* W czystym projekcie pet-clinic, stworzyć encję Pet posiadającą:
* String name, LocalDate birthDate, PetType petType (ENUM do stworzenia), Owner owner (relacja many to one)
* */