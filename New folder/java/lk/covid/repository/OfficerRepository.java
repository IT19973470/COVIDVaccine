package lk.covid.repository;

import lk.covid.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, String> {
}
