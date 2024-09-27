package com.ssafit.video.model.repository;

import java.util.List;
import java.util.Map;

import com.ssafit.video.model.dto.Video;

public interface VideoRepository {
	public List<Video> getAllVideos();
	
	public Map<String, Integer> getVideoMap();
	
	public Video getVideoById(int id);
	
	public List<Video> getVideosSortedByViewCount();
	
	public List<Video> filterVideosByCategory(String Category);
}
