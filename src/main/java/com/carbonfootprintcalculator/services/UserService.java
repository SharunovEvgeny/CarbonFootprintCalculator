package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.User;
import com.carbonfootprintcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> createUser(User user) {
    User newUser = new User(user.getUsername(), user.getName(), user.getSurname());
    return Optional.of(userRepository.save(newUser));
  }

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public boolean deleteByUsername(String username) {
    if (existsByUsername(username)) {
      userRepository.delete(userRepository.findByUsername(username).get());
      return true;
    } else {
      return false;
    }
  }

  public Optional<User> updateUser(long id, User user) {
    Optional<User> existedUser = userRepository.findById(id);
    if (existedUser.isPresent()) {
      User updatedUser = existedUser.get();
      updatedUser.setName(user.getName());
      updatedUser.setSurname(user.getSurname());
      updatedUser.setUsername(user.getUsername());
      return Optional.of(userRepository.save(updatedUser));
    }
    return Optional.empty();
  }
}
