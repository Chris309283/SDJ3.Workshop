package dk.via.sdj3.assignment2.controller;

import dk.via.sdj3.assignment2.model.Order;
import dk.via.sdj3.assignment2.repo.OrderRepo;
import dk.via.sdj3.assignment2.service.RabbitMQOrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api/") public class OrderController
{
  @Autowired
  private RabbitMQOrderProducer rabbitMQOrderProducer;
  @Autowired
  private OrderRepo orderRepo;

/*@Autowired
  public OrderController(RabbitMQOrderProducer rabbitMQOrderProducer, OrderRepo orderRepo)
  {
    this.rabbitMQOrderProducer = rabbitMQOrderProducer;
    this.orderRepo = orderRepo;
  }*/


  @GetMapping("/order") public String MakeOrder(@RequestParam("id") int id,
      @RequestParam("description") String description,
      @RequestParam("amount") float amount,
      @RequestParam("delivered") boolean delivered)
  {
    Order order = new Order();
    order.setId(id);
    order.setDescription(description);
    order.setAmount(amount);
    order.setDelivered(delivered);
    if (rabbitMQOrderProducer.sendOrder(order))
    {
      System.out.println("Order sent to RabbitMQ: " + order.getDescription());
      return "Order sent to RabbitMQ: " + order.getDescription();
    }
    else
    {
      return "Order not sent to RabbitMQ: " + order.getDescription();
    }
  }

  @GetMapping("/orders")
  public ResponseEntity<List<Order>> getAllOrders()
  {
    List<Order> orders = orderRepo.findAll();
    if (orders.isEmpty())
    {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/order/{id}")
  public ResponseEntity<Order> getOrder(@PathVariable("id") int id)
  {
    Optional<Order> order = orderRepo.findById(id);
    if (order.isEmpty())
    {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(order.get());
  }

  @PostMapping("/order")
  public ResponseEntity<Order> createOrder(@RequestBody Order order)
  {
    try
    {
      orderRepo.save(order);
      return ResponseEntity.ok(order);
    }
    catch (Exception e)
    {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/order/{id}")
  public ResponseEntity<Order> updateOrder(@PathVariable("id") int id, @RequestBody Order order)
  {
    Optional<Order> orderOptional = orderRepo.findById(id);
    if (orderOptional.isEmpty())
    {
      return ResponseEntity.notFound().build();
    }
    order.setId(id);
    orderRepo.save(order);
    return ResponseEntity.ok(order);
  }

  @DeleteMapping("/order/{id}")
  public ResponseEntity<Order> deleteOrder(@PathVariable("id") int id)
  {
    Optional<Order> orderOptional = orderRepo.findById(id);
    if (orderOptional.isEmpty())
    {
      return ResponseEntity.notFound().build();
    }
    orderRepo.deleteById(id);
    return ResponseEntity.ok(orderOptional.get());
  }

  @GetMapping("/order/delivered")
  public ResponseEntity<List<Order>> getDeliveredOrders()
  {
    List<Order> orders = orderRepo.findByDelivered(true);
    if (orders.isEmpty())
    {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(orders);
  }


}
