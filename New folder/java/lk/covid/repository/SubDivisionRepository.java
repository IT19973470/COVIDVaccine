package lk.covid.repository;

import lk.covid.entity.SubDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubDivisionRepository extends JpaRepository<SubDivision, String> {
}
