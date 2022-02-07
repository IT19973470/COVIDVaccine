package lk.vaccine.repository;

import lk.vaccine.entity.VaccineUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineUserRepository extends JpaRepository<VaccineUser, String> {

    VaccineUser getAllByUsernameAndPassword(String username, String password);


}
