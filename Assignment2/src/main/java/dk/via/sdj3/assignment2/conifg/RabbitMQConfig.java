package dk.via.sdj3.assignment2.conifg;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class RabbitMQConfig
{
  @Bean Exchange orderExchange()
  {
    return new DirectExchange("x.sdj3.order.exchange");
  }

  @Bean Queue orderQueue()
  {
    return new Queue("x.sdj3.order.queue",false);
  }

  @Bean Binding orderBinding()
  {
    return BindingBuilder.bind(orderQueue()).to(orderExchange()).with("order.routingKey").noargs();
  }

  @Bean MessageConverter jsonMessageConverter()
  {
    return new Jackson2JsonMessageConverter();
  }
}
