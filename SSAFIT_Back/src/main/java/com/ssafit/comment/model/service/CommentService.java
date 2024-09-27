package com.ssafit.comment.model.service;

import com.ssafit.comment.model.dto.Comment;
import java.util.ArrayList;

public interface CommentService {
    ArrayList<Comment> getAllComments(String videoId);
    void addComment(Comment comment);
    void deleteComment(int commentId, String videoId);
}
