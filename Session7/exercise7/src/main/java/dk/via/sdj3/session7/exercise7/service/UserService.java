package dk.via.sdj3.session7.exercise7.service;

import dk.via.sdj3.session7.exercise7.dao.UserRepository;
import dk.via.sdj3.session7.exercise7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class UserService implements UserIface
{
  UserRepository userRepository;

  @Autowired public UserService(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @Override public User create(User user)
  {
    return userRepository.save(user);
  }

  @Override public List<User> getAll()
  {
    return (List<User>) userRepository.findAll();
  }

  @Override public Iterable<User> getAllIter()
  {
    return userRepository.findAll();
  }

  @Override public Optional<User> findById(int id)
  {
    return userRepository.findById(id);
  }

  @Override public Optional<User> findByEmail(String email)
  {
    return userRepository.findByEmail(email);
  }

  @Override public User update(User user)
  {
    return userRepository.save(user);
  }

  @Override public void delete(int id)
  {
    userRepository.deleteById(id);
  }
}
