package dk.via.sdj3.dependency.guice;

import com.google.inject.AbstractModule;

public class AppointmentModule extends AbstractModule
{
  protected void configure()
  {
    // mapping between interface and implementation
    bind(NotificationService.class).to(SMSService.class);
  }
}
