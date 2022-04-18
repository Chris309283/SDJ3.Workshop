package dk.via.sdj3.assignment2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Order.class)
@Entity
@Table(name = "orders")
public class Order implements Serializable
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String description;
  private float amount;
  private boolean delivered;

  public Order()
  {
  }

  public Order(int id, String description, float amount, boolean delivered)
  {
    this.id = id;
    this.description = description;
    this.amount = amount;
    this.delivered = delivered;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public float getAmount()
  {
    return amount;
  }

  public void setAmount(float amount)
  {
    this.amount = amount;
  }

  public boolean isDelivered()
  {
    return delivered;
  }

  public void setDelivered(boolean delivered)
  {
    this.delivered = delivered;
  }

  @Override public String toString()
  {
    return "Order{" + "id=" + id + ", description='" + description + '\''
        + ", amount=" + amount + ", delivered=" + delivered + '}';
  }
}

