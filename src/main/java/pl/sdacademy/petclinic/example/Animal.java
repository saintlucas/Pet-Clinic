package pl.sdacademy.petclinic.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Animal {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
}
