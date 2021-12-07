package hu.unideb.jsfspring.repositry;

import hu.unideb.jsfspring.entity.FoodDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<FoodDTO, Long> {
}
