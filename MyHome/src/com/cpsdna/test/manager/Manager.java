package com.cpsdna.test.manager;

public class Manager {
	private static Manager me;
	
	private double roomWidth;
	private double roomHeight;
	private double teatableWidth;
	private double teatableHeight;
	private double footstoolWidth;
	private double footstoolHeight;
	
	private Manager(){
	}
	
	public static Manager instance(){
		if(me == null)
			me = new Manager();
		return me;
	}

	public double getRoomWidth() {
		return roomWidth;
	}

	public void setRoomWidth(double roomWidth) {
		this.roomWidth = roomWidth;
	}

	public double getRoomHeight() {
		return roomHeight;
	}

	public void setRoomHeight(double roomHeight) {
		this.roomHeight = roomHeight;
	}

	public double getTeatableWidth() {
		return teatableWidth;
	}

	public void setTeatableWidth(double teatableWidth) {
		this.teatableWidth = teatableWidth;
	}

	public double getTeatableHeight() {
		return teatableHeight;
	}

	public void setTeatableHeight(double teatableHeight) {
		this.teatableHeight = teatableHeight;
	}

	public double getFootstoolWidth() {
		return footstoolWidth;
	}

	public void setFootstoolWidth(double footstoolWidth) {
		this.footstoolWidth = footstoolWidth;
	}

	public double getFootstoolHeight() {
		return footstoolHeight;
	}

	public void setFootstoolHeight(double footstoolHeight) {
		this.footstoolHeight = footstoolHeight;
	}

	
}
