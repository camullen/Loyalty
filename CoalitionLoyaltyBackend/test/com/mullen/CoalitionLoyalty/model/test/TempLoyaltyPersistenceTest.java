/**
 * 
 */
package com.mullen.CoalitionLoyalty.model.test;

import junit.framework.TestCase;

import com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence;
import com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author Cameron Mullen
 *
 */
public class TempLoyaltyPersistenceTest extends TestCase {

	private LoyaltyPersistence persist = new TempLoyaltyPersistence();
	
	
	/**
	 * @param name
	 */
	public TempLoyaltyPersistenceTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#getUser(int)}.
	 */
	public void testGetUser() {
		int userID = 12345;
		int userPoints = 15;
		
		User sourceUser = new User(userID, userPoints);
		User initialGet = persist.getUser(userID);

		persist.updateUser(sourceUser);
		User secondGet = persist.getUser(userID);
		
		assertNull(initialGet);
		assertEquals(secondGet, sourceUser);
		
		
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#updateUser(com.mullen.CoalitionLoyalty.model.User)}.
	 */
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#getLocation(int)}.
	 */
	public void testGetLocation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#updateLocation(com.mullen.CoalitionLoyalty.model.Location)}.
	 */
	public void testUpdateLocation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#getAllUsers()}.
	 */
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.mullen.CoalitionLoyalty.dao.TempLoyaltyPersistence#getAllLocations()}.
	 */
	public void testGetAllLocations() {
		fail("Not yet implemented");
	}

}
