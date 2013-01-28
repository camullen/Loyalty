package com.mullen.CoalitionLoyalty.model;

public class LoyaltyBrain {

	public static final int SUCCESS = 1;
	public static final int UNKNOWN_ERROR = 0;
	public static final int INSUFFICIENT_POINTS = -1;
	
	public int doVisit(User usr, Location loc){
		usr.incrementPoints(loc.getVisitValue());
		
		return SUCCESS;
	}
	
	public int doRedeem(User usr, Location loc){
		boolean hasEnough = usr.decreasePoints(loc.getRedeemCost());
		if(hasEnough)
			return SUCCESS;
		else
			return INSUFFICIENT_POINTS;
		
	}
	
	
	
}
