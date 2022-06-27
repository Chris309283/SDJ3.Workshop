package dk.via.sdj3.dependency.guice;

import com.google.inject.Inject;

public class AppointmentConsumer
{
  private NotificationService notificationService;

  // Dependency injection

  // method (setter) level based dependency injection
  @Inject
  public void setNotificationService(NotificationService notificationService)
  {
    this.notificationService = notificationService;
  }

  public Boolean sendNotification(String message, String recipient)
  {
    return notificationService.sendNotification(message, recipient);
  }
}
