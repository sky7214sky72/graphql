package org.api.graphql.model.dto;

import java.util.List;

public record UserDto(
    Long id,
    String name,
    String email,
    List<PostDto> posts,
    int followerCount
) {

}
