package client;

import model.Order;
import service.OrderMessageService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client
{
  public static void main(String[] args) throws MalformedURLException
  {
    URL WSDL_URL = new URL("http://localhost:9090/Vlads-dildo-order-service?wsdl");

    QName SERVICE_NAME = new QName("http://service.assignment1.sdj3.via.dk/",
        "OrderMessageService");

    Service service = Service.create(WSDL_URL, SERVICE_NAME);
    System.out.println("SOAP Service is now created... ");

    OrderMessageService os = service.getPort(OrderMessageService.class);
    System.out.println("================================================");
    Order o1 = new Order(1000001,"Small Pink one", 200,true);
    os.create(o1);
    System.out.println("================================================");
    System.out.println(os.read(1000001).toString());
    System.out.println("================================================");
    Order o2 = new Order(2000000,"Big Pink One", 300, false);
    os.update(o2,1000001);
    System.out.println("================================================");
    System.out.println(os.read(2000000).toString());


   // Order o2 = new Order(2000000,"Big Pink One", 300, false);
    os.delete(o2);
  }
}
