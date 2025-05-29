package org.api.graphql.model.dto;

public record PostDto(
    Long id,
    String title,
    int likeCount
) {}
