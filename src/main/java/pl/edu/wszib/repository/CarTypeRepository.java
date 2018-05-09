package pl.edu.wszib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.entity.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}
