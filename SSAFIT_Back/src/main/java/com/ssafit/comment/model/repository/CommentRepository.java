package com.ssafit.comment.model.repository;

import com.ssafit.comment.model.dto.Comment;
import java.util.ArrayList;

public interface CommentRepository {
        
	public abstract ArrayList<Comment> findAllByVideoId(String videoId);
	
	public abstract void save(Comment comment);
    	
	public abstract void deleteById(int commentId, String videoId);
	
}
