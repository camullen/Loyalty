/**
 * 
 */
package com.mullen.CoalitionLoyalty.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * Basic implementation of the LoyaltyPersistence interface that stores the objects in memory
 * @author Cameron Mullen
 *
 */
public class TempLoyaltyPersistence implements LoyaltyPersistence {

	Map<Integer, User> allUsers = new HashMap<Integer, User>();
	Map<Integer, Location> allLocations = new HashMap<Integer, Location>();
	
	
	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getUser(int)
	 */
	@Override
	public User getUser(int userID) {
		return allUsers.get(userID);
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#updateUser(com.mullen.CoalitionLoyalty.model.User)
	 */
	@Override
	public int updateUser(User usr) {
		allUsers.put(usr.getUserID(), usr);
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getLocation(int)
	 */
	@Override
	public Location getLocation(int locationID) {
		return allLocations.get(locationID);
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#updateLocation(com.mullen.CoalitionLoyalty.model.Location)
	 */
	@Override
	public int updateLocation(Location loc) {
		allLocations.put(loc.getLocationID(), loc);
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		return new ArrayList<User>(allUsers.values());
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getAllLocations()
	 */
	@Override
	public List<Location> getAllLocations() {
		return new ArrayList<Location>(allLocations.values());
	}

}
