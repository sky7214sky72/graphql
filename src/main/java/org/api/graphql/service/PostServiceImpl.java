package org.api.graphql.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.api.graphql.model.dto.PostDto;
import org.api.graphql.model.entity.Post;
import org.api.graphql.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Override
  public List<PostDto> findByUserId(Long id) {
    List<Post> posts = postRepository.findAllByUserId(id);
    return posts.stream()
        .map(it -> new PostDto(it.getId(), it.getTitle(), it.getLikeCount()))
        .toList();
  }
}
