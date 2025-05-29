package org.api.graphql.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.api.graphql.model.dto.PostDto;
import org.api.graphql.model.dto.UserDto;
import org.api.graphql.model.entity.User;
import org.api.graphql.service.PostService;
import org.api.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

  private final UserService userService;
  private final PostService postService;

  @QueryMapping
  public UserDto user(@Argument Long id) {
    return userService.findById(id);
  }

  @SchemaMapping(typeName = "User", field = "posts")
  public List<PostDto> posts(UserDto userDto) {
    return postService.findByUserId(userDto.id());
  }

  @SchemaMapping(typeName = "User", field = "followerCount")
  public int followerCount(UserDto userDto) {
    return 42;
  }
}
