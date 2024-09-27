package com.ssafit.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
class VideoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private VideoService service = VideoServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "doDetail":
			doDetail(request, response);
		}
	}
	
	// 선택한 영상의 정보 표시
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute(, service);
		
		// 길 지정
		RequestDispatcher rdp = request.getRequestDispatcher("/WEB-INF/video/videoDetail.jsp");
		
		// 포워드로 보내줌
		rdp.forward(request, response);
	}
}