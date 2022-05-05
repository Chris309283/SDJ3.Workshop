
package dk.via.sdj3.assignment2.repo;

import dk.via.sdj3.assignment2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderRepo extends JpaRepository<Order, Integer> {
  List<Order> findByDelivered(boolean b);
}



