package com.comments.commentApp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commentor", nullable = false)
    private String commentor;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "dateofcomment", nullable = false)
    private LocalDateTime dateOfComment;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentor() {
        return commentor;
    }

    public void setCommentor(String commentor) {
        this.commentor = commentor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(LocalDateTime dateOfComment) {
        this.dateOfComment = dateOfComment;
    }
}