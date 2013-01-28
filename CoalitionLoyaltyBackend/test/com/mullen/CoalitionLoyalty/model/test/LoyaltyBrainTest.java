package com.mullen.CoalitionLoyalty.model.test;

import junit.framework.TestCase;

import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.LoyaltyBrain;
import com.mullen.CoalitionLoyalty.model.User;

public class LoyaltyBrainTest extends TestCase {

	public LoyaltyBrainTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDoVisit() {
		int userID = 12345;
		int numPoints = 4;
		
		int locationID = 9876;
		int locationValue = 2;
		int locationRedeemCost = 20;
		
		User usr = new User(userID, numPoints);
		Location loc = new Location(locationID, locationValue, locationRedeemCost);
		
		LoyaltyBrain brain = new LoyaltyBrain();
		brain.doVisit(usr, loc);
		
		assertEquals(usr.getUserID(), userID);
		assertEquals(usr.getNumPoints(), numPoints + locationValue);
		
		assertEquals(loc.getLocationID(), locationID);
		assertEquals(loc.getVisitValue(), locationValue);
		assertEquals(loc.getRedeemCost(), locationRedeemCost);
		
	}

	public void testDoRedeem() {
		int userID1 = 12345;
		int numPoints1 = 45;
		
		int userID2 = 201;
		int numPoints2 = 13;
		
		int locationID = 9876;
		int locationValue = 2;
		int locationRedeemCost = 20;
		
		User usr1 = new User(userID1, numPoints1);
		User usr2 = new User(userID2, numPoints2);
		Location loc = new Location(locationID, locationValue, locationRedeemCost);
		
		LoyaltyBrain brain = new LoyaltyBrain();
		
		int redeemSuccess1 = brain.doRedeem(usr1, loc);
		int redeemSuccess2 = brain.doRedeem(usr2, loc);
		
		
		assertEquals(redeemSuccess1, LoyaltyBrain.SUCCESS);
		assertEquals(usr1.getUserID(), userID1);
		assertEquals(usr1.getNumPoints(), numPoints1 - locationValue);
		
		assertEquals(redeemSuccess2, LoyaltyBrain.INSUFFICIENT_POINTS);
		assertEquals(usr2.getUserID(), userID2);
		assertEquals(usr2.getNumPoints(), numPoints2);
		
		assertEquals(loc.getLocationID(), locationID);
		assertEquals(loc.getVisitValue(), locationValue);
		assertEquals(loc.getRedeemCost(), locationRedeemCost);
	}

}
