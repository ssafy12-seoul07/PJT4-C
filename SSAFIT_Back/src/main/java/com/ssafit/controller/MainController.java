package com.ssafit.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		switch(path) {
		case "video":
			doVideo(request, response); // 게시판 관리로 포워딩
		case "comment":
			doComment(request, response); // 댓글 관리로 포워딩
		}
	}

	private void doComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CommentController.java로 forwarding
		request.getRequestDispatcher("/CommentController.java").forward(request, response);

	}

	private void doVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// VideoController.java로 forwarding
		request.getRequestDispatcher("/VideoController.java").forward(request, response);

	}
}