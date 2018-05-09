package pl.edu.wszib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
