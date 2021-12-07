package hu.unideb.jsfspring.repositry;

import hu.unideb.jsfspring.entity.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonDTO, Long> {

    PersonDTO findTitleByPersonName(String personName);
}
