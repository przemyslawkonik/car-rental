package pl.edu.wszib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
