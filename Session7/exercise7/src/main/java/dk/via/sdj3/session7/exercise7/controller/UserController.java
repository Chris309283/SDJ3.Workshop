package dk.via.sdj3.session7.exercise7.controller;

import dk.via.sdj3.session7.exercise7.model.User;
import dk.via.sdj3.session7.exercise7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.Optional;

@RestController @RequestMapping("/api") public class UserController
{

  UserService userService;

  @Autowired public UserController(UserService userService)
  {
    this.userService = userService;
  }

  @PostMapping("/users") public User createUser(@RequestBody User user)
  {
    return userService.create(user);
  }

  @GetMapping("/users") public Iterable<User> getAllUsers()
  {
    return userService.getAllIter();
  }

  @GetMapping("/users/{id}") public User getUserById(@PathVariable("id") int id)
      throws ChangeSetPersister.NotFoundException
  {
    /* User user = userService.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException("User not found"));
    return userService.findById(id);*/
    Optional<User> user = userService.findById(id);
    if (user.isPresent())
    return user.get();
    else
    throw new ChangeSetPersister.NotFoundException();
  }

  @PutMapping("/users/{id}") public User updateUser(@PathVariable("id") int id, @RequestBody User user)
      throws ChangeSetPersister.NotFoundException
  {
    Optional<User> oldUser = userService.findById(id);
    if (oldUser.isPresent())
    return userService.update(user);
    else
      throw new ChangeSetPersister.NotFoundException();
  }

}

