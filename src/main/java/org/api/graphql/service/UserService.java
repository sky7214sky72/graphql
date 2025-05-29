package org.api.graphql.service;

import org.api.graphql.model.dto.UserDto;

public interface UserService {

  UserDto findById(Long id);
}
