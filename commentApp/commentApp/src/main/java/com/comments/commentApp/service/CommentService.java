package com.comments.commentApp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.commentApp.entity.Comment;
import com.comments.commentApp.repo.CommentRepo;

@Service
public class CommentService {

	 @Autowired
	    private CommentRepo commentRepository;

	    public List<Comment> getAllComments() {
	        return commentRepository.findAll();
	    }

	    public List<Comment> getCommentsByUsername(String username) {
	        return commentRepository.findByCommentor(username);
	    }

	    public List<Comment> getCommentsByDate(LocalDateTime date) {
	        return commentRepository.findByDateOfComment(date);
	    }

	    public Comment saveComment(Comment comment) {
	        return commentRepository.save(comment);
	    }

	    public Comment updateComment(Long id, Comment comment) {
	        Comment existingComment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
	        existingComment.setCommentor(comment.getCommentor());
	        existingComment.setText(comment.getText());
	        existingComment.setDateOfComment(comment.getDateOfComment());
	        return commentRepository.save(existingComment);
	    }

	    public void deleteComment(Long id) {
	        commentRepository.deleteById(id);
	    }
}
