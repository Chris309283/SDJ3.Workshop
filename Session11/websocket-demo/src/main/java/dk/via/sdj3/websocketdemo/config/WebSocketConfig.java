package dk.via.sdj3.websocketdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

// WebSocket configuration
@Component
public class WebSocketConfig
{
  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
    return new ServerEndpointExporter();
  }
}
