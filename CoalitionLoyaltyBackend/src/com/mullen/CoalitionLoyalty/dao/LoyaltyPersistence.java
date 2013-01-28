/**
 * 
 */
package com.mullen.CoalitionLoyalty.dao;

import java.util.List;

import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author Cameron Mullen
 * 
 */
public interface LoyaltyPersistence {

	/**
	 *  RESULT CODE: Operation was successful
	 */
	public static final int SUCCESS = 1;
	
	/**
	 * RESULT CODE: Operation had an unknown error
	 */
	public static final int UNKNOWN_ERROR = 0;

	
	
	public void close();
	
	
	/**
	 * Gets all Location objects in storage
	 * @return A List of all Location objects in storage. Returns an empty list if no Locations stored.
	 */
	public List<Location> getAllLocations();

	/**
	 * Gets all Users in storage
	 * @return A List of all Users in storage. Returns an empty list if no Users stored. 
	 */
	public List<User> getAllUsers();
	
	/**
	 * Retrieves a User from persistent storage given its ID
	 * 
	 * @param locationID
	 *            The ID of the Location
	 * @return A User object representing the Location in persistent storage.
	 *         Returns null if no User found.
	 */
	
	public Location getLocation(int locationID);

	
	
	/**
	 * Retrieves a User from persistent storage given its ID
	 * 
	 * @param userID
	 *            The ID of the User
	 * @return A User object representing the User in persistent storage.
	 *         Returns null if no User found.
	 */
	public User getUser(int userID);

	
	/**
	 * Updates the Location in persistent storage. If it does not exist, the Location is added.
	 * @param loc The Location object to be updated.
	 * @return A RESULT CODE based upon the outcome of the operation
	 */
	
	public int updateLocation(Location loc);

	
	/**
	 * Updates the User in persistent storage. If it does not exist, the Location is added.
	 * @param usr The User object to be updated.
	 * @return A RESULT CODE based upon the outcome of the operation
	 */
	
	public int updateUser(User usr);

}
