package dk.via.exam.client;

import dk.via.exam.shared.Adder;

import java.rmi.Naming;

public class MyClient
{
  public static void main(String[] args)
  {
    try
    {
      Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/sonoo");
      System.out.println(stub.add(1, 2));
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
