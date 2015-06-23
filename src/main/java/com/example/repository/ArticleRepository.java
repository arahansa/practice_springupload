package com.example.repository;

import com.example.model.BoardArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arahansa on 2015-06-16.
 */
public interface ArticleRepository extends JpaRepository<BoardArticle, Long> {

}
