package service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Random;

@WebService(endpointInterface = "service.WakeUpMessageService",serviceName = "WakeUpService")
public class WakeUpMessageServiceImpl implements WakeUpMessageService
{

  @Override public String wakeUp(@WebParam(name = "name") String name)
  {
    return name + " wake it's time to wake up! " + getRandomMessage();
  }

  private String getRandomMessage()
  {
    ArrayList<String> wakeUpMessages = new ArrayList<>();
    wakeUpMessages.add("Now please!");
    wakeUpMessages.add("You are going to be late!");
    wakeUpMessages.add("Your breakfast is ready!");

    return wakeUpMessages.get(new Random().nextInt(wakeUpMessages.size()));
  }
}
