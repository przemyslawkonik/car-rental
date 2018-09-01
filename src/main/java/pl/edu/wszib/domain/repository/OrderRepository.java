package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.entity.Employee;
import pl.edu.wszib.domain.entity.Order;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(Integer id);

    Order findByRentalDate(Date rentalDate);

    Order findByReturnDate(Date returnDate);

    Order findByStatus(String status);

    Order findByCustomer(Customer customer);

    Order findByEmployee(Employee employee);

    Order findByCar(Car car);
}
