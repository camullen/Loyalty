/**
 * 
 */
package com.mullen.CoalitionLoyalty.dao;

import java.util.List;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.dynamodb.AmazonDynamoDB;
import com.amazonaws.services.dynamodb.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBMapper;
import com.mullen.CoalitionLoyalty.model.Location;
import com.mullen.CoalitionLoyalty.model.User;

/**
 * @author Cameron Mullen
 *
 */
public class DynamoDBLoyaltyPersistence implements LoyaltyPersistence {

	
	private AmazonDynamoDB database;
	private DynamoDBMapper mapper;
	
	public DynamoDBLoyaltyPersistence(){
		database = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		mapper = new DynamoDBMapper(database);
	}
	
	
	
	public void close(){
		
		database.shutdown();
	}
	
	public void finalize(){
		
		close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getAllLocations()
	 */
	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getLocation(int)
	 */
	@Override
	public Location getLocation(int locationID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#getUser(int)
	 */
	@Override
	public User getUser(int userID) {
		return mapper.load(User.class, userID );
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#updateLocation(com.mullen.CoalitionLoyalty.model.Location)
	 */
	@Override
	public int updateLocation(Location loc) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.mullen.CoalitionLoyalty.dao.LoyaltyPersistence#updateUser(com.mullen.CoalitionLoyalty.model.User)
	 */
	@Override
	public int updateUser(User usr) {
		mapper.save(usr);
		return SUCCESS;
	}

}
