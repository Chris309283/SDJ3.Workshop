package dk.via.sdj3.restorderapi.controller;


import dk.via.sdj3.restorderapi.model.Order0;
import dk.via.sdj3.restorderapi.repository.OrderRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/") public class OrderController0
{
  private OrderRepository orderRepository;

  public OrderController0(OrderRepository orderRepository)
  {
    this.orderRepository = orderRepository;
  }

  @RequestMapping("/home") @ResponseBody public String welcome()
  {
    return "Welcome to the world of RESTful APIs";
  }

  //GET-ing an order given the id

  @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE})
  @ResponseBody
  public Order0 getOrderById(@PathVariable("id") Long id)
  {
    return orderRepository.findById(id);
  }

  @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE})
  @ResponseBody
  public List<Order0> getAllOrders()
  {
    return orderRepository.findAll();
  }

  @RequestMapping(value = "/orders.json", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<Order0> getAllOrdersJ()
  {
    return orderRepository.findAll();
  }


  //PUT-ing U --- Update

  @PutMapping(value = "/orders")
  public Order0 update(@RequestBody Order0 order0)
  {
    orderRepository.saveAndUpdate(order0);
    return order0;
  }

  //Post-ing C --- Create

  @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE})
  @ResponseBody
  public Order0 createOrder (@RequestBody Order0 order0)
  {
    System.out.println("[Backend - Server] Creating order: "+ order0.getOrderId());
    return orderRepository.saveAndUpdate(order0);
  }

  //Delete - ing
  @DeleteMapping("/orders/{id}")
  public void delete(@PathVariable("id")Long id)
  {
    orderRepository.delete(id);
    System.out.println("[Backend - Server] Order deleted");
  }
}
