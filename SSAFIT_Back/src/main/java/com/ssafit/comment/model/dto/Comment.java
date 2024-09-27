package com.ssafit.comment.model.dto;

public class Comment {
    private int commentId;
    private String videoId;
    private String title;
    private String content;
    private String author;

    public Comment(int commentId, String videoId, String title, String content, String author) {
        this.commentId = commentId;
        this.videoId = videoId;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
