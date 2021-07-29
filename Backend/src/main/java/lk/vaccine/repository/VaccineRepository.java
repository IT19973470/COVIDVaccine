package lk.vaccine.repository;

import lk.vaccine.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, String> {
}
