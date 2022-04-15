package server;

import service.OrderMessageService;
import service.OrderMessageServiceImpl;

import javax.xml.ws.Endpoint;

public class Server
{
  public static void main(String[] args)
  {
    OrderMessageService service = new OrderMessageServiceImpl();
    String address = "http://localhost:9090/Vlads-dildo-order-service";
    Endpoint.publish(address,service);
    System.out.println("*********** The Server is ready... ************");
    System.out.println("===============================================");

    try
    {
      Thread.sleep(5*60*1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println("********** Server shut down ***********");
    System.exit(0);
  }
}
