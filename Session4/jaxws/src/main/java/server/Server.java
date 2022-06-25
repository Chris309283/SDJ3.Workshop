package server;



import service.WakeUpMessageServiceImpl;

import javax.xml.ws.Endpoint;

public class Server
{
  public static void main(String[] args)
  {
    WakeUpMessageServiceImpl service = new WakeUpMessageServiceImpl();
    String address = "http://localhost:9091/jaxws-wakeUp-service";
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
