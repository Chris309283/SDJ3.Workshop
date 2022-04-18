
package dk.via.sdj3.assignment2.repo;

import dk.via.sdj3.assignment2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
  List<Order> findByDelivered(boolean b);
}



