package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(Integer id);

    Employee findByName(String name);

    Employee findBySurname(String surname);
}
