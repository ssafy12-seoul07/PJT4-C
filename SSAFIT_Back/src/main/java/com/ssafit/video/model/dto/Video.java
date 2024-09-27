package com.ssafit.video.model.dto;

public class Video {
	private String id;
	private String title;
	private String description;
	private int viewCnt;
	private String category;
	
	public Video(String id, String title, String description, int viewCnt, String category) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.viewCnt = viewCnt;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", description=" + description + ", viewCnt=" + viewCnt
				+ ", category=" + category + "]";
	}
}
	