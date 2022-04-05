package dk.via.sdj3.session7.exercise7.service;

import dk.via.sdj3.session7.exercise7.model.User;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface UserIface
{
  User create(User user);
  List<User> getAll();
  Iterable<User> getAllIter();
  Optional<User> findById(int id);
  Optional<User> findByEmail(String email);
  User update(User user);
  void delete(int id);
}
