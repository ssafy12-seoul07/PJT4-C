package com.ssafit.comment.model.service;

import com.ssafit.comment.model.dto.Comment;
import java.util.ArrayList;

public interface CommentService {
    
	public abstract ArrayList<Comment> getAllComments(String videoId);
    
	public abstract void addComment(Comment comment);
    
	public abstract void deleteComment(int commentId, String videoId);
}
