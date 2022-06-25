package dk.via.exam.server;

import dk.via.exam.shared.Adder;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MyServer
{
  public static void main(String[] args)
  {
    try
    {
      Adder stub = new AdderRemote();
      Naming.rebind("rmi://localhost:5000/sonoo", stub);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
