package dk.via.sdj3.assignment2.controller;

import dk.via.sdj3.assignment2.model.Product;
import dk.via.sdj3.assignment2.service.RabbitMQProductProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ProductController
{
  private RabbitMQProductProducer rabbitMQProductProducer;

  public ProductController(RabbitMQProductProducer rabbitMQProductProducer)
  {
    this.rabbitMQProductProducer = rabbitMQProductProducer;
  }

  @GetMapping("/product") public String createProduct(@RequestParam("productName") String productName,@RequestParam("productId") String productId)
  {
    Product product = new Product();
    product.setProductName(productName);
    product.setProductId(productId);
    rabbitMQProductProducer.send(product);

    if(rabbitMQProductProducer.send(product))
    {
      System.out.println(product.getProductName() + " Sent to RabbitMQ");
      return "Product sent to RabbitMQ";
    }
    else
      return "Product not sent to RabbitMQ";
  }

}
