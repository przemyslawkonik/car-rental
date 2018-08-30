package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(Integer id);

    List<Customer> findBySurname(String surname);

    Customer findByPhone(String phone);

    Customer findByEmail(String email);

    Customer findByName(String username);
}
