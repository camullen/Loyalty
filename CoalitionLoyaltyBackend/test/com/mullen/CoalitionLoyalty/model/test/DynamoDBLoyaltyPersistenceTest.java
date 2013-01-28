/**
 * 
 */
package com.mullen.CoalitionLoyalty.model.test;

import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence;
import com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence;
import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author Cameron Mullen
 *
 */
public class DynamoDBLoyaltyPersistenceTest extends TestCase  {
	
	private DynamoDBLoyaltyPersistence persist;
	
	
	/**
	 * @param name
	 */
	public DynamoDBLoyaltyPersistenceTest(String name) {
		super(name);
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		persist = new DynamoDBLoyaltyPersistence(); 
		
	}
	
	protected void tearDown() throws Exception {
		persist.killAll();
		persist.close();
		super.tearDown();
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getAllLocations()}.
	 */
	public void testGetAllLocations() {
		int numItemsToAdd = 100;
		
		for(int i = 0; i < numItemsToAdd; i++){
			persist.updateLocation(new Location());
		}
		
		List<Location> allLocations = persist.getAllLocations();
		
		assertEquals(allLocations.size(), numItemsToAdd);
		
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getAllUsers()}.
	 */
	public void testGetAllUsers() {
		int numItemsToAdd = 100;
		
		for(int i = 0; i < numItemsToAdd; i++){
			persist.updateUser(new User());
		}
		
		List<User> allUsers = persist.getAllUsers();
		
		assertEquals(allUsers.size(), numItemsToAdd);
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getLocation(int)}.
	 */

	public void testUpdateLocation() {
		int locationID = new Random().nextInt();
		Location loc = new Location(locationID, 1, 10);
		int result = persist.updateLocation(loc);
		Location retrievedLoc = persist.getLocation(locationID);
		
		assertEquals(result, LoyaltyPersistence.SUCCESS);
		assertEquals(retrievedLoc, loc);
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#updateUser(com.mullen.CoalitionLoyalty.model.User)}.
	 */
	public void testUpdateUser() {
		int userID = 1234;
		
		User usr = new User(userID, 0);
		int result = persist.updateUser(usr);
		User retrievedUser = persist.getUser(userID);
		
		
		assertEquals(result, LoyaltyPersistence.SUCCESS);
		assertEquals(retrievedUser, usr);
		
	}

}
