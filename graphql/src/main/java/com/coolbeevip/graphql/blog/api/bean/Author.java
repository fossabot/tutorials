package com.coolbeevip.graphql.blog.api.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhanglei
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

  private String id;
  private String name;
  private String thumbnail;
  private List<Post> posts;
}
