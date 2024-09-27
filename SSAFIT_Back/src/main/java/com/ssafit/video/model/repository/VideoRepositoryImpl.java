package com.ssafit.video.model.repository;

import java.util.*;

import com.ssafit.video.model.dto.Video;

public class VideoRepositoryImpl implements VideoRepository {
	private List<Video> videoList = new ArrayList<>();
	private List<String> partsList = new ArrayList<>();
	private Map<String, Integer> videoMap = new HashMap<>();
	private static VideoRepositoryImpl videoRepo = new VideoRepositoryImpl();
	
	private VideoRepositoryImpl() {}
	
	public static VideoRepositoryImpl getInstance() {
		return videoRepo;
	}

	@Override
	public List<Video> getAllVideos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getVideoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideosSortedByViewCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> filterVideosByCategory(String Category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getVideoMap() {
		return videoMap;
	}
	
}
