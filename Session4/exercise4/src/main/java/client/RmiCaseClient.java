package client;

import server.TextConverter;

import java.rmi.RemoteException;

public class RmiCaseClient
{
  private TextConverter textConverter;

  public RmiCaseClient()
  {

  }

  public String convertString(String text, String type) throws RemoteException
  {
  if (type.equalsIgnoreCase("toupper"))
  {
    return textConverter.toUpperCase(text);
  }
  else
  {
    return textConverter.capitalizeFirstCharacter(text);
  }
  }
}
