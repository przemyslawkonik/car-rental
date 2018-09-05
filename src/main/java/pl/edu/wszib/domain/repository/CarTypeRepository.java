package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.CarType;

import java.util.List;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {

    CarType findById(Integer id);

    List<CarType> findAllByBrand(String brand);

    List<CarType> findAllByModel(String brand, String model);

    List<CarType> findAllByEngineCapacity(String enginecapacity);

    List<CarType> findAllByEngineType(String enginetype);
}
