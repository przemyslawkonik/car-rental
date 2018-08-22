package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {

    CarType findByModel(String brand, String model);

    CarType findByEngineCapacity(String enginecapacity);

    CarType findByEngineType(String enginetype);

}
