package dk.via.sdj3.session7.indirectcomm.group.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GroupMulticastServer
{
  // group multicast IP in the range 224.0.0.0 to 239.255.255.255
  //224.0.0.0 is reversed
  final static String INET_ADDR = "228.1.2.3";
  final static int PORT = 6789;

  public static void main(String[] args) throws UnknownHostException
  {
    String[] techs = {"Websockets", "RabbitMQ", "gRPC", "REST", "GraphQL", "JavaScript", "Firebase"};

    //get the address to connect
    InetAddress address = InetAddress.getByName(INET_ADDR);

    // Open new datagram socket for sending data

    try (DatagramSocket serverSocket = new DatagramSocket())
    {
      for (String t : techs)
      {
        int grp = getRandomGroup() + 1;
        String msg = "Group" + grp +" is using " + t + " in their project";

        //create a packet
        byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket msgPkt = new DatagramPacket(msgBytes,msgBytes.length,address,PORT);

        // send the packet
        serverSocket.send(msgPkt);
        System.out.println("### Server has sent a packet with the message: " + msg);
        TimeUnit.SECONDS.sleep(5);
      }
    }
    catch (IOException | InterruptedException ioe)
    {
      ioe.printStackTrace();
    }
  }

  private static int getRandomGroup()
  {
    Random random = new Random();
    return random.nextInt(9);
  }
}
