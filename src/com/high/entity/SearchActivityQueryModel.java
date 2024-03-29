package com.high.entity;

import java.util.Date;

public class SearchActivityQueryModel {

	//每页显示多少条
	public static Integer NUM_ACTIVITY_PER_PAGE=5;
	
	private String query;
	private String topCategory;
	private String secCategory;
	private Location activityLocation;
	private Date startTime;
	private Integer page;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTopCategory() {
		return topCategory;
	}
	public void setTopCategory(String topCategory) {
		this.topCategory = topCategory;
	}
	public String getSecCategory() {
		return secCategory;
	}
	public void setSecCategory(String secCategory) {
		this.secCategory = secCategory;
	}
	public Location getActivityLocation() {
		return activityLocation;
	}
	public void setActivityLocation(Location activityLocation) {
		this.activityLocation = activityLocation;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
