package com.ssafit.controller;

import java.io.IOException;

import com.ssafit.video.model.service.VideoService;
import com.ssafit.video.model.service.VideoServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
class VideoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static VideoService service = VideoServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("난 비디오 컨트롤러야");
		String action = (String) request.getAttribute("action");
		switch(action) {
		case "detail":
			doDetail(request, response);
			break;
		}
	}
	
	// 선택한 영상의 정보 표시
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getAttribute("id");
		
		request.setAttribute("video", service.getVideoById(id));
		
		// 길 지정
		RequestDispatcher rdp = request.getRequestDispatcher("/WEB-INF/video/videoDetail.jsp");
		
		// 포워드로 보내줌
		rdp.forward(request, response);
	}
}