package dk.via.sdj3.restorderapi.repository;

import dk.via.sdj3.restorderapi.model.Order0;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // notify the Spring FrameWork that it is a Java Bean
public class OrderRepository
{
  // N/B will use SOLID Later
  private static final Map<Long, Order0> orderMap = new HashMap<>();

  // assuming dat arfe persisted to the database
  static
  {
    initDataSource();
  }

  private static void initDataSource()
  {
    Order0 o1 = new Order0(1L, "Exotic Sandwich for lunch", 55.00, true);
    Order0 o2 = new Order0(2L, "Pizza", 45.00, false);
    Order0 o3 = new Order0(3L, "toast", 15.00, false);

    orderMap.put(o1.getOrderId(), o1);
    orderMap.put(o2.getOrderId(), o2);
    orderMap.put(o3.getOrderId(), o3);
  }

  //CRUD R-Get
  public Order0 findById(Long id)
  {
    return orderMap.get(id);
  }
  //find all
  public List<Order0> findAll()
  {
    Collection<Order0> c = orderMap.values();
    return new ArrayList<>(c);
  }

  //Post-ing C U--- Create and update
  public Order0 saveAndUpdate(Order0 order0)
  {
    orderMap.put(order0.getOrderId(),order0);
    return order0;
  }

  //Delete-ing D --- Delete
  public void delete(Long id)
  {
    orderMap.remove(id);
  }




}
