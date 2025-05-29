package org.api.graphql.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.api.graphql.model.dto.PostDto;
import org.api.graphql.model.dto.UserDto;
import org.api.graphql.model.entity.User;
import org.api.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDto findById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPosts().stream()
        .map(it -> new PostDto(it.getId(), it.getTitle(), it.getLikeCount())).toList(), 24);
  }
}
