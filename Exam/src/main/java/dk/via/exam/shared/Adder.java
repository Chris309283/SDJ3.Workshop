package dk.via.exam.shared;

import java.rmi.Remote;

public interface Adder extends Remote
{
  int add (int x, int y);
}
