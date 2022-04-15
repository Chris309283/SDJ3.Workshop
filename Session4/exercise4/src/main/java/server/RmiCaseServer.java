package server;

import javax.jws.WebService;
import java.rmi.RemoteException;
@WebService(endpointInterface = "via.dk.sdj3.session4.exercises.RmiCaseServer", serviceName = "")
public class RmiCaseServer implements TextConverter
{
  public void start()
  {

  }

  @Override public String toUpperCase(String text) throws RemoteException
  {
    return text.toLowerCase();
  }

  @Override public String capitalizeFirstCharacter(String text)
      throws RemoteException
  {
    return Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
  }
}
