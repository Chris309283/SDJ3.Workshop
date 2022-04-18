package dk.via.sdj3.assignment2.service;

import dk.via.sdj3.assignment2.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQOrderProducer
{
  private RabbitTemplate rabbitTemplate;
  private String EXCHANGE = "x.sdj3.order.exchange";
  private String ROUTING_KEY = "order.routingKey";

  public RabbitMQOrderProducer(RabbitTemplate rabbitTemplate)
  {
    this.rabbitTemplate = rabbitTemplate;
  }

  public Boolean sendOrder(Order order)
  {
    try {
      rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
      System.out.println("Order sent to RabbitMQ: " + order);
      return true;
    }catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
