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
	
	
	
	public List<String> getPartsList() {
		return partsList;
	}

	public void setPartsList(List<String> partsList) {
		this.partsList = partsList;
	}

	@Override
	public List<Video> getAllVideos() {
		return videoList;
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

	@Override
	public void initailizeVideos() {
		Video video1 = new Video("50WCSpZtdmA", "First Video", "This is the first video description", 100, "Tutorial");
        videoList.add(video1);
        videoMap.put(video1.getId(), videoMap.size());

        Video video2 = new Video("Kk7TQGqQ3nA", "Second Video", "This is the second video description", 200, "Entertainment");
        videoList.add(video2);
        videoMap.put(video1.getId(), videoMap.size());

        Video video3 = new Video("MTU4iCDntjs", "Third Video", "This is the third video description", 300, "Education");
        videoList.add(video3);
        videoMap.put(video3.getId(), videoMap.size());

        Video video4 = new Video("D3yExRi7EME", "Fourth Video", "This is the fourth video description", 150, "Music");
        videoList.add(video4);
        videoMap.put(video4.getId(), videoMap.size());

        Video video5 = new Video("02K-k6daPb4", "Fifth Video", "This is the fifth video description", 250, "Fitness");
        videoList.add(video5);
        videoMap.put(video5.getId(), videoMap.size());
        
        for(int i = 0; i<videoList.size(); i++) {
        	if(!partsList.contains(videoList.get(i).getCategory())) {
        		partsList.add(videoList.get(i).getCategory());
        	}
        }
	}
	
}
