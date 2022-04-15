package toJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Order;

import java.io.FileWriter;
import java.io.IOException;

public class ToJsonXml
{
  public static void main(String[] args)
  {
    // POJO to convert to JSON, XML
    Order order = createObject();

    // Gson gson = new Gson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Java objects to json
    String json = gson.toJson(order);
    System.out.println(json);

    // Java objects to file
    try (FileWriter writer = new FileWriter(
        "C:\\Users\\Bruger\\OneDrive - ViaUC\\Software Engineering\\3. Semester\\SDJ3\\4. Web Services\\Jsonxml\\order.json");)
    {
      gson.toJson(order, writer);
      System.out.println("Object written to file");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  private static Order createObject()
  {
    Order order = new Order();
    order.setDescription("Hooker");
    order.setAmount(999.99);
    order.setDelivered(false);
    return order;
  }
}
