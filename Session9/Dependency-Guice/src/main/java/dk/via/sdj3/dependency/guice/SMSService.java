package dk.via.sdj3.dependency.guice;

public class SMSService implements NotificationService
{

  @Override public boolean sendNotification(String message, String recipient)
  {
    //code to sending SMS
    System.out.println("Sending SMS to " + recipient + ": " + message);

    return true;
  }
}
