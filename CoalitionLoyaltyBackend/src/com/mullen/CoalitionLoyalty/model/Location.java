package com.mullen.CoalitionLoyalty.model;

import java.util.Random;

public class Location {
	public static Random RAND_GEN = new Random();
	public static final int DEFAULT_VISIT_VALUE = 1;
	public static final int DEFAULT_REDEEM_COST = 10;
	
	
	//FIELDS
	private int locationID;
	private int visitValue;
	private int redeemCost;
	
	
	
	//Constructors
	
	public Location(){
		this(DEFAULT_VISIT_VALUE, DEFAULT_REDEEM_COST);
	}
	
	public Location(int visitValue, int redeemCost){
		this(RAND_GEN.nextInt(), visitValue, redeemCost);
	}
	
	public Location(int locationID, int visitValue, int redeemCost){
		this.locationID = locationID;
		this.visitValue = visitValue;
		this.redeemCost = redeemCost;
	}
	
	
	
	
	
	//GETTERS & SETTERS
	
	/**
	 * @return the locationID
	 */
	public int getLocationID() {
		return locationID;
	}
	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	/**
	 * @return the visitValue
	 */
	public int getVisitValue() {
		return visitValue;
	}
	/**
	 * @param visitValue the visitValue to set
	 */
	public void setVisitValue(int visitValue) {
		this.visitValue = visitValue;
	}
	/**
	 * @return the redeemCost
	 */
	public int getRedeemCost() {
		return redeemCost;
	}
	/**
	 * @param redeemCost the redeemCost to set
	 */
	public void setRedeemCost(int redeemCost) {
		this.redeemCost = redeemCost;
	}
	
	
	
	
	
}
