package lk.covid.repository;

import lk.covid.entity.VaccineUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineUserRepository extends JpaRepository<VaccineUser, String> {
}
