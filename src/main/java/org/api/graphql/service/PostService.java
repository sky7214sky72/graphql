package org.api.graphql.service;

import java.util.List;
import org.api.graphql.model.dto.PostDto;

public interface PostService {

  List<PostDto> findByUserId(Long id);
}
