package service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface WakeUpMessageService
{
  String wakeUp(@WebParam(name="name") String name);
}
