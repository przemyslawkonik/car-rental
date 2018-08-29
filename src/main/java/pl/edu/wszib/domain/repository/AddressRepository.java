package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCustomerId(Integer customerId);
}
