package pl.sdacademy.petclinic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.model.Visit;

public interface VisitRepository extends JpaRepository<Visit,Long> {
}
