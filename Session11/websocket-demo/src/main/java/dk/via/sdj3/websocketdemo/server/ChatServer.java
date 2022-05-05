package dk.via.sdj3.websocketdemo.server;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/chat")
public class ChatServer
{
  //trigger when a message is received from a client
  @OnMessage
  public String echo(String message)
  {
    //logging
    return "From server: " + message;
  }
}
