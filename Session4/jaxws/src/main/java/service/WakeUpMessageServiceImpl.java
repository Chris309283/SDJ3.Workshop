package service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Random;

@WebService(endpointInterface = "via.dk.sdj3.session4.jaxws.service.WakeUpMessageService",serviceName = "WakeUpService")
public class WakeUpMessageServiceImpl implements WakeUpMessageService
{

  @Override public String wakeUp(@WebParam(name = "name") String name)
  {
    return name + " wake the fuck up biiitch! " + getRandomMessage();
  }

  private String getRandomMessage()
  {
    ArrayList<String> wakeUpMessages = new ArrayList<>();
    wakeUpMessages.add("lol");
    wakeUpMessages.add("lmao");
    wakeUpMessages.add("get rekt");

    return wakeUpMessages.get(new Random().nextInt(wakeUpMessages.size()));
  }
}
