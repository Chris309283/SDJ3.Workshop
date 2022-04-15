package dk.via.sdj3.assignment2.conifg;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class RabbitMQConfig
{
  @Bean Exchange productExchange()
  {
    return new DirectExchange("x.sdj3.product.exchange");
  }

  @Bean Queue productQueue()
  {
    return new Queue("x.sdj3.product.queue");
  }

  @Bean Binding productBinding()
  {
    // return new Binding("x.sdj3.product.queue", Binding.DestinationType.QUEUE, "x.sdj3.product.exchange", "x.sdj3.product.queue", null);
    return BindingBuilder.bind(productQueue()).to(productExchange())
        .with("product.routingKey").noargs();
  }

  @Bean MessageConverter jsonMessageConverter()
  {
    return new Jackson2JsonMessageConverter();
  }
}
