package com.ssafit.video.model.service;

import java.util.List;
import com.ssafit.video.model.dto.Video;

public interface videoService {
	// 모든 비디오 List를 반환
	public abstract List<Video> getAllvideos();
	
	// id가 일치하는 비디오 반환
	public abstract Video getVideoById(int id);
	
	// 조회수 기준 정렬
	public abstract List<Video> getVideosSortByViewCount();
	
	// 부위별 운동 필터링
	public abstract List<Video> filterVideoBuCategory(String category);
}
