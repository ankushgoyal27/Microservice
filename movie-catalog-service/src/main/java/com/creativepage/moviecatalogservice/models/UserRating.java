package com.creativepage.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	private List<Rating> userRating;
	
	public UserRating() {
		super();
	}

	public UserRating(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	
}
