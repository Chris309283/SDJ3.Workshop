package model;

public class Order
{
  private int orderId;
  private String description;
  private double amount;
  private boolean delivered;

  public Order()
  {
  }

  public Order(int orderId, String description, double amount,
      boolean delivered)
  {
    this.orderId = orderId;
    this.description = description;
    this.amount = amount;
    this.delivered = delivered;
  }

  public int getOrderId()
  {
    return orderId;
  }

  public void setOrderId(int orderId)
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

  @Override public String toString()
  {
    return "Order{" + "orderId=" + orderId + ", description='" + description
        + '\'' + ", amount=" + amount + ", delivered=" + delivered + '}';
  }
}
