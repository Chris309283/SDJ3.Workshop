package dk.via.sdj3.dependency.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class NotificationClient
{
  public static void main(String[] args)
  {
    Injector injector = Guice.createInjector(new AppointmentModule());
    AppointmentConsumer consumer = injector.getInstance(AppointmentConsumer.class);
    consumer.sendNotification("Hello World!","world");
  }
}
