package lk.covid.repository;

import lk.covid.entity.VaccineToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineTokenRepository extends JpaRepository<VaccineToken, String> {
}
