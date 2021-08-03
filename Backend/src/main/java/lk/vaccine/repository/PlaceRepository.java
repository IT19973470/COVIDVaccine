package lk.vaccine.repository;

import lk.vaccine.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, String> {

    List<Place> findAllBySubDivisionSubDivisionId(String subDivisionId);

}
