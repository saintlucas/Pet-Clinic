package pl.sdacademy.petclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String city;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "owner")
    private List<Pet> pets;
}

  /*  Stworzyć encję Owner posiadającą pola: String name, String address, String city, List<Pet> pets (relacja jeden do wielu)*/
