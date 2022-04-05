package dk.via.sdj3.session7.indirectcomm.group.clients;

import java.io.IOException;
import java.net.*;

public class GrpMulticastNewGroupOne
{
  final static String INET_ADDR = "228.1.2.3";
  final static int PORT = 6789;

  public static void main(String[] args) throws UnknownHostException
  {
    InetAddress address = InetAddress.getByName(INET_ADDR);

    //create buffer of bytes
    byte[] buf = new byte[1024];

    //create a new multicastSocket
    try (MulticastSocket socket = new MulticastSocket(PORT))
    {
      InetSocketAddress group = new InetSocketAddress(address, PORT);
      NetworkInterface networkInterface = NetworkInterface.getByName("NewGroupOne");

      //Join the group
      socket.joinGroup(group,networkInterface);
      while (true)
      {
        //create packet with data
        DatagramPacket msgPkt = new DatagramPacket(buf,buf.length);
        socket.receive(msgPkt);
        System.out.println(new String(msgPkt.getData(),0, msgPkt.getLength()));
      }
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
  }
}
