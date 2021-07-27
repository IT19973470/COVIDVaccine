package lk.vaccine.repository;

import lk.vaccine.entity.VaccineToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineTokenRepository extends JpaRepository<VaccineToken, String> {
}
