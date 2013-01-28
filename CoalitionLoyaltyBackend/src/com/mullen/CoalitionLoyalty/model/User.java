/**
 * 
 */
package com.mullen.CoalitionLoyalty.model;

import java.util.Random;

/**
 * @author cmullen
 *
 */
public class User {
	//UTILITY OBJECT
	private static Random RAND_GEN = new Random();
	
	//FIELDS
	
	private int userID;
	private int numPoints;
	
	
	// CONSTRUCTORS
	
	public User(int userID, int numPoints){
		this.userID = userID;
		this.numPoints = numPoints;
	}
	
	
	
	public User(){
		this(RAND_GEN.nextInt());
	}
	
	
	
	
	public User(int userID){
		this(userID, 0);
	}
	
	
	
	public void incrementPoints(int points){
		numPoints += points;
	}
	
	
	public boolean decreasePoints(int points){
		if(points > numPoints)
			return false;
		else {
			numPoints -= points;
			return true;
		}
	}
	
	
	//GETTERS & SETTERS
	
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the numPoints
	 */
	public int getNumPoints() {
		return numPoints;
	}
	/**
	 * @param numPoints the numPoints to set
	 */
	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	
	
	
	
}
