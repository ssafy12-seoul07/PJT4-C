package com.ssafit.comment.model.service;

import com.ssafit.comment.model.dto.Comment;
import com.ssafit.comment.model.repository.CommentRepository;
import com.ssafit.comment.model.repository.CommentRepositoryImpl;

import java.util.ArrayList;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public ArrayList<Comment> getAllComments(String videoId) {
        return commentRepository.findAllByVideoId(videoId);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int commentId, String videoId) {
        commentRepository.deleteById(commentId, videoId);
    }
}
