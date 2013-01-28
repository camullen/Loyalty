/**
 * 
 */
package com.mullen.CoalitionLoyalty.model.test;

import junit.framework.TestCase;

import com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence;
import com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author Cameron Mullen
 *
 */
public class DynamoDBLoyaltyPersistenceTest extends TestCase  {
	
	private LoyaltyPersistence persist;
	
	
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
		persist.close();
		super.tearDown();
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getAllLocations()}.
	 */
	public void testGetAllLocations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getAllUsers()}.
	 */
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getLocation(int)}.
	 */
	public void testGetLocation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#getUser(int)}.
	 */
	
	public void testUpdateLocation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence#updateUser(com.mullen.CoalitionLoyalty.model.User)}.
	 */
	public void testUpdateUser() {
		int userID = 1234;
		
		User usr = new User(userID, 0);
		int result = persist.updateUser(usr);
		User retrievedUser = persist.getUser(userID);
		
		assertEquals(retrievedUser, usr);
		assertEquals(result, LoyaltyPersistence.SUCCESS);
	}

}
