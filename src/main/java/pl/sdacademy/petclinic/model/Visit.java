package pl.sdacademy.petclinic.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;

    @OneToOne
    private Vet vet;

    @OneToOne
    private Pet pet;


}

    /*Stworzyć encję Visit posiadającą pola:
        LocalDate date, String description, Vet vet (relacja one to one), Pet pet (relacja one to one)*/