/**
 * 
 */
package com.mullen.CoalitionLoyalty.model;

import java.util.Random;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBTable;

/**
 * @author Cameron Mullen
 *
 */

@DynamoDBTable(tableName = "UsersTest")
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
	

	//UTILITY METHODS
	
	
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
	@DynamoDBHashKey(attributeName="userID")
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



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numPoints;
		result = prime * result + userID;
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (numPoints != other.numPoints) {
			return false;
		}
		if (userID != other.userID) {
			return false;
		}
		return true;
	}

	
	
	
	
}
