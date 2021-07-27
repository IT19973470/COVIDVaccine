package lk.vaccine.repository;

import lk.vaccine.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, String> {
}
