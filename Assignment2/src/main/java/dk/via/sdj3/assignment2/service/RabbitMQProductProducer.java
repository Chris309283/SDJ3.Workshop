package dk.via.sdj3.assignment2.service;

import dk.via.sdj3.assignment2.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProductProducer
{
  private RabbitTemplate rabbitTemplate;
  private String EXCHANGE = "x.sdj3.product.exchange";
  private String ROUTING_KEY = "product.routingKey";

  public RabbitMQProductProducer(RabbitTemplate rabbitTemplate)
  {
    this.rabbitTemplate = rabbitTemplate;
  }

  public Boolean send(Product product)
  {
    try
    {
      rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, product);
      //logging
      System.out.println("Product sent to RabbitMQ: " + product);
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }
}
