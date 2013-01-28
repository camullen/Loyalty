/**
 * 
 */
package com.mullen.CoalitionLoyalty.model;

import com.mullen.CoalitionLoyalty.dao.DynamoDBLoyaltyPersistence;
import com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence;

/**
 * @author Cameron Mullen
 *
 */
public class LoyaltyController {

	public static final int SUCCESS = 1;
	public static final int FAILURE = -1;
	public static final int LOCATION_NOT_EXIST = -2;
	public static final int USER_NOT_EXIST = -3;
	public static final int INSUFFICIENT_POINTS = -4;
	
	private static LoyaltyBrain brain = new LoyaltyBrain();
	private static LoyaltyPersistence persist = new DynamoDBLoyaltyPersistence();
	
	
	public static int visit(int userID, int locationID){
		User usr = null;
		Location loc = null;
		int result = getUserAndLocation(usr, loc, userID, locationID);
		if(result != SUCCESS) return result;
		brain.doVisit(usr, loc);
		persist.updateLocation(loc);
		persist.updateUser(usr);
		return SUCCESS;
	}
	
	public static int redeem(int userID, int locationID){
		User usr = null;
		Location loc = null;
		int result = getUserAndLocation(usr, loc, userID, locationID);
		if(result != SUCCESS) return result;
		
		int transactionResult = brain.doRedeem(usr, loc);
		if(transactionResult == LoyaltyBrain.INSUFFICIENT_POINTS) return INSUFFICIENT_POINTS;
		persist.updateLocation(loc);
		persist.updateUser(usr);
		return SUCCESS;
	}
	
	private static int getUserAndLocation(User usr, Location loc, int userID, int locationID){
		usr = persist.getUser(userID);
		if(usr == null) return USER_NOT_EXIST;
		loc = persist.getLocation(locationID);
		if(loc == null) return LOCATION_NOT_EXIST;
		return SUCCESS;
	}
	
	
	
	
	
	public static int addUser(){
		User usr = new User();
		while(persist.getUser(usr.getUserID()) != null && usr.getUserID() != FAILURE){
			usr = new User();
		}
		try {
			persist.updateUser(usr);
			return usr.getUserID();
		} catch (Exception e){
			e.printStackTrace();
			return FAILURE;
		}
	}
	
	
	public static int addLocation(){
		Location loc = new Location();
		while(loc.getLocationID() != FAILURE && persist.getLocation(loc.getLocationID()) != null){
			loc = new Location();
		}
		return addLocationToPersistence(loc);
	}
	
	
	public static int addLocation(int visitValue, int redeemCost){
		Location loc = new Location(visitValue, redeemCost);
		while(loc.getLocationID() != FAILURE && persist.getLocation(loc.getLocationID()) != null){
			loc = new Location(visitValue, redeemCost);
		}
		return addLocationToPersistence(loc);
	}
	
	
	private static int addLocationToPersistence(Location loc){
		try {
			persist.updateLocation(loc);
			return loc.getLocationID();
		} catch (Exception e) {
			e.printStackTrace();
			return FAILURE;
		}
	}
		
	
	
	
	
	
	
}
