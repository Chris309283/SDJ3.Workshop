package dk.via.sdj3.session7.exercise7.dao;

import dk.via.sdj3.session7.exercise7.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>
{
  Optional<User> findByEmail(String email);
}
