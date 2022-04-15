package dk.via.sdj3.restorderapi.model;

public class Order0
{
  private Long orderId;
  private String description;
  private double amount;
  private boolean delivered;

  public Order0()
  {
  }

  public Order0(long orderId, String description, double amount,
      boolean delivered)
  {
    this.orderId = orderId;
    this.description = description;
    this.amount = amount;
    this.delivered = delivered;
  }

  public long getOrderId()
  {
    return orderId;
  }

  public void setOrderId(long orderId)
  {
    this.orderId = orderId;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
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

}
