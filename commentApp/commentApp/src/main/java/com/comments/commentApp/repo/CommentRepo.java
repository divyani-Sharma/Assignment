package com.comments.commentApp.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comments.commentApp.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	 List<Comment> findByCommentor(String commentor);
	 List<Comment> findByDateOfComment(LocalDateTime dateOfComment);

}
