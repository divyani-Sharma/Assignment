package com.comments.commentApp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comments.commentApp.entity.Comment;
import com.comments.commentApp.service.CommentService;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {

		@Autowired
	    private CommentService commentService;

	    @GetMapping
	    public List<Comment> getAllComments() {
	        return commentService.getAllComments();
	    }

	    @GetMapping("/search")
	    public List<Comment> searchComments(@RequestParam(required = false) String username,
	                                        @RequestParam(required = false) String date) {
	        if (username != null) {
	            return commentService.getCommentsByUsername(username);
	        } else if (date != null) {
	            LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
	            return commentService.getCommentsByDate(dateTime);
	        }
	        return commentService.getAllComments();
	    }

	    @PostMapping
	    public Comment createComment(@RequestBody Comment comment) {
	        return commentService.saveComment(comment);
	    }

	    @PutMapping("/{id}")
	    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
	        return commentService.updateComment(id, comment);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteComment(@PathVariable Long id) {
	        commentService.deleteComment(id);
	    }
}
