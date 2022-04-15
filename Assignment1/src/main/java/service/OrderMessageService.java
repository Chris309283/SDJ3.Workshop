package service;

import model.Order;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface OrderMessageService
{
  void create(@WebParam(name="order") Order order);
  Order read(@WebParam(name="id") int id);
  void update(@WebParam(name="order") Order order,@WebParam(name="id") int id);
  void delete(@WebParam(name="order") Order order);
}
