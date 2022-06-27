package dk.via.sdj3.dependecyspring.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Drink
{
  private int id;
  private String name;
  private String description;

  @Autowired
  private Room room;

  public void show() {
    System.out.println("Drink: " + name + ", " + description);
    room.setId(1);
    room.setName("Room 1");
    room.roomService();
  }
}
