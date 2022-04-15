package dao.dao;

import java.util.List;
import java.util.Optional;

public interface DaoApi<T>
{
  Optional<T> get(long id);
  List<T> getAll();
  void save(T t);
  void update(T t, String[] params, double price, int qty);
  void delete(T t);
}
