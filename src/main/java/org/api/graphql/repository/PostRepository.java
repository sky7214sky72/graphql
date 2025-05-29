package org.api.graphql.repository;

import java.util.List;
import org.api.graphql.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findAllByUserId(Long id);
}
