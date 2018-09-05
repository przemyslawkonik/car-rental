package pl.edu.wszib.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.entity.Employee;
import pl.edu.wszib.domain.entity.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(Integer id);

    List<Order> findAllByRentalDate(Date rentalDate);

    List<Order> findAllByReturnDate(Date returnDate);

    List<Order> findAllByStatus(String status);

    List<Order> findAllByCustomer(Customer customer);

    List<Order> findAllByEmployee(Employee employee);

    List<Order> findAllByCar(Car car);
}
