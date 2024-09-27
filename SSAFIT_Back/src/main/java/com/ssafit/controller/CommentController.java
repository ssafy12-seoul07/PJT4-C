package com.ssafit.controller;

import java.io.IOException;

import com.ssafit.comment.model.dto.Comment;
import com.ssafit.comment.model.service.CommentService;
import com.ssafit.comment.model.service.CommentServiceImpl;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.ArrayList;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
	private CommentService service = CommentServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    	String action = req.getParameter("action");
        
    	switch (action) {
            case "list":
                doList(req, res);
                break;
            case "add":
                doAdd(req, res);
                break;
            case "delete":
                doRemove(req, res);
                break;
            default:
                System.out.println("Error");  // Default case to handle invalid actions
                break;
        }
    }

    private void doList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    	String videoId = req.getParameter("videoId");
        
    	ArrayList<Comment> comments = service.getAllComments(videoId);
        
    	req.setAttribute("comments", comments);
        
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/comment/commentList.jsp");
        
    	dispatcher.forward(req, res);
    }
    

    private void doAdd(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
    	String videoId = req.getParameter("videoId");
        
    	String title = req.getParameter("title");
        
    	String content = req.getParameter("content");
        
    	String author = req.getParameter("author");

        Comment comment = new Comment(0, videoId, title, content, author);  // commentId는 자동 생성
        
        service.addComment(comment);
        
        res.sendRedirect("CommentController?action=list&videoId=" + videoId);
    }

    private void doRemove(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
    	int commentId = Integer.parseInt(req.getParameter("commentId"));
        
    	String videoId = req.getParameter("videoId");
        
    	service.deleteComment(commentId, videoId);
        
    	res.sendRedirect("CommentController?action=list&videoId=" + videoId);
    }
}
