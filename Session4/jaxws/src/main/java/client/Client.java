package client;


import service.WakeUpMessageService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client
{
  public static void main(String[] args) throws MalformedURLException
  {
    URL WSDL_URL = new URL("http://localhost:9090/jaxws-wakeUp-service?wsdl");

    QName SERVICE_NAME = new QName("http://service.jaxws.session4.sdj3.dk.via/",
        "WakeUpService");

    //create the Jaxws (CXF) supplied service
    Service service = Service.create(WSDL_URL, SERVICE_NAME);
    System.out.println("SOAP Service is now created... ");

    //Now you can consume the SOAP Service
    //Use the getPort method to obtain the service interface
    WakeUpMessageService ws = service.getPort(WakeUpMessageService.class);
    System.out.println("================================================");
    System.out.println(ws.wakeUp("Vlad"));
    System.out.println("================================================");

  }
}
/*
curl --header "content -type text/xml" -d @WakeUpMessageEnvolope.xml
http://localhost:9090/jaxws-wakeUp-service*/
