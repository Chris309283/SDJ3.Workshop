package dk.via.sdj3.session8.rabbitMQ.Publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CanteenProductPublisher
{
  private final static String QUEUE_NAME = "Via_Canteen_Products_Queue";

  public static void main(String[] args) throws IOException, TimeoutException
  {
    String[] products = {"Milk", "Bread", "Coffee", "Tea", "Cake", "Chips",
        "Soda", "Candy", "Chips"};
    // factory pattern to init connection
    ConnectionFactory connectionFactory = new ConnectionFactory();
    // set the host name
    connectionFactory.setHost("localhost");
    // create a connection using the factory instance
    // and initialize the channel using the connection
    // channel is responsible for sending and receiving messages plus some qu
    try (Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel())
    {
      // with the channel we can declare, bind, unbind, delete queue, ...
      // the queue
      // queue name, passive, durable, exclusive, autoDelete, arguments
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      // publish a message to the queue
      for (String product : products)
      {
        String message = "Product: " + product;
        // exchange, routing key, AMQP basic properties, message body
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [Pub] Sent '" + message + "'");
      }
    }
  }
}
