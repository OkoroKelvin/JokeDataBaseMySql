package com.transition.jokemysql.data.repository;

import com.transition.jokemysql.data.model.Comment;
import com.transition.jokemysql.data.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
