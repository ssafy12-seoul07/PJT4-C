package com.ssafit.video.model.service;

import java.util.List;

import com.ssafit.video.model.dto.Video;
import com.ssafit.video.model.repository.VideoRepositoryImpl;

public class VideoServiceImpl implements VideoService{
	private static VideoService service = new VideoServiceImpl();
	private VideoRepositoryImpl videoRepo = VideoRepositoryImpl.getInstance();

	public static VideoService getInstance() {
		return service;
	}
	
	@Override
	public List<Video> getAllvideos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getVideoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideosSortByViewCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> filterVideoBuCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
