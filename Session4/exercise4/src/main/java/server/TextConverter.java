package server;

import javax.jws.WebService;
import java.rmi.Remote;
import java.rmi.RemoteException;

@WebService
public interface TextConverter extends Remote
{
  public String toUpperCase(String text) throws RemoteException;
  public String capitalizeFirstCharacter(String text) throws RemoteException;
}
