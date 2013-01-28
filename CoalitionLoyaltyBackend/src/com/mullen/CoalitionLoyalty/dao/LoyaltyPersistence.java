/**
 * 
 */
package com.mullen.CoalitionLoyalty.dao;

import java.util.List;

import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author cmullen
 *
 */
public interface LoyaltyPersistence {
	
	public static final int SUCCESS = 1;
	public static final int UNKNOWN_ERROR = 0;
	
	
	public User getUser(int userID);
	public int updateUser(User usr);
	
	public Location getLocation(int locationID);
	public int updateLocation(Location loc);
	
	public List<User> getAllUsers();
	public List<Location> getAllLocations();
	

}
