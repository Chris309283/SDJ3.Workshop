package dk.via.sdj3.dependecyspring.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Room
{
    private int id;
    private String name;

    public void roomService()
    {
        System.out.println("\nRoom service is here with your drink, " + name + "!");
    }
}
