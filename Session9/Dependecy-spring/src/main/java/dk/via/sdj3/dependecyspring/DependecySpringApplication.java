package dk.via.sdj3.dependecyspring;


import dk.via.sdj3.dependecyspring.model.Drink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication public class DependecySpringApplication
{

  public static void main(String[] args)
  {
    ConfigurableApplicationContext appContext = SpringApplication.run(DependecySpringApplication.class, args);
   Drink drink = appContext.getBean(Drink.class);
   drink.setName("Cola");
   drink.setDescription("A fizzy drink");

   drink.show();
  }

}
