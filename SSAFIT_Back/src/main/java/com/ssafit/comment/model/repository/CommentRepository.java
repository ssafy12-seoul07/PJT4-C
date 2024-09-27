package com.ssafit.comment.model.repository;

import com.ssafit.comment.model.dto.Comment;
import java.util.ArrayList;

public interface CommentRepository {
    ArrayList<Comment> findAllByVideoId(String videoId);
    void save(Comment comment);
    void deleteById(int commentId, String videoId);
}
