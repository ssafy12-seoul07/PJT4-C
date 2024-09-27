package com.ssafit.video.model.repository;

import java.util.*;

import com.ssafit.video.model.dto.Video;

public class VideoRepositoryImpl {
	private List<Video> videoList = new ArrayList<>();
	private List<String> partsList = new ArrayList<>();
	private Map<Integer, Integer> videoMap = new HashMap<>();
	private static VideoRepositoryImpl videoRepo = new VideoRepositoryImpl();
	
	private VideoRepositoryImpl() {}
	
	public static VideoRepositoryImpl getInstance() {
		return videoRepo;
	}
	
}
