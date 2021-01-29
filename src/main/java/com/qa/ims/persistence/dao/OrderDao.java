package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDao implements IDomainDao<Orders> {
	private ItemDao itemDao;
	private CustomerDao customerDao;
	
	 
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	public OrderDao(ItemDao itemDao, CustomerDao customerDao) {
		super();
		this.itemDao = itemDao;
		this.customerDao = customerDao;
	}

	public List<Items> getAllItems(Long oID){
		List<Long> itemIds = new ArrayList<>();
		try(Connection connection = DatabaseUtilities.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orderline WHERE fk_oid = ?");){
							statement.setLong(1, oID);
							try (ResultSet resultSet = statement.executeQuery();){
								while (resultSet.next()) {
									itemIds.add(resultSet.getLong("fk_iid"));
								} 
								
							}
								
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			
			
		}
		
		return itemIds.stream().map(itemId -> itemDao.read(itemId)).collect(Collectors.toList());
		
	}
	
	public double calcOrderValue (Long oID) {
		double value = this.getAllItems(oID).stream().map(item -> item.getPrice()).reduce((acc,  next) -> acc + next)
				.orElse(0.0);
		this.update(new Orders(oID, null, value));
		return value;
		// taken from Nicks example <.<
	}
	

	
	
	
	public Orders addItems(Long oID, Long iID) {
		 try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                PreparedStatement statement = connection
	                        .prepareStatement("INSERT INTO orderline(fk_oid, fk_iid) VALUES(?, ?)");) {
	            statement.setLong(1, oID);
	            statement.setLong(2, iID);
	            statement.executeUpdate();
	            return readLatest();
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
		 calcOrderValue(oID);
			return read(oID);
		
	}
	
	public Orders removeItems(Long Oid, Long Iid) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("DELETE FROM orderline(fk_oid, fk_iid) VALUES(?, ?)");) {
            statement.setLong(1, Oid);
            statement.setLong(2, Iid);
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
	 calcOrderValue(Oid); 
		return read(Oid);
		
	}


	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            statement.executeUpdate("INSERT INTO orders(fk_cid) values(" + orders.getCustomer().getId() + ")");
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e); 
            LOGGER.error(e.getMessage());
        }
		return null;
	}
	
    public Orders read(Long Oid) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE oid = ?");) {
            statement.setLong(1, Oid);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }


	@Override
	public List<Orders> readAll() {
		   try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
	            List<Orders> orders = new ArrayList<>();
	            while (resultSet.next()) {
	                orders.add(modelFromResultSet(resultSet));
	            }
	            return orders;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	    }
	   public Orders readLatest() {
	        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY oid DESC LIMIT 1");) {
	            resultSet.next();
	            return modelFromResultSet(resultSet);
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return null;
	    }




	@Override  
	public Orders update(Orders orders) {
	      try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                PreparedStatement statement = connection
	                        .prepareStatement("UPDATE orders SET order_value = ? WHERE oid = ?");) {
	            statement.setDouble(1, orders.getOrderValue());
	            statement.setLong(2, orders.getOid());
	            statement.executeUpdate();
	            return read(orders.getOid());
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
		return null;
	}

	@Override
	public int delete(long Oid) {
		   try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                Statement statement = connection.createStatement();) {
	            return statement.executeUpdate("delete from orders where oid = " + Oid);
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
		return 0;
	}
 
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oID = resultSet.getLong("oid");
		Customer customer = customerDao.read(resultSet.getLong("fk_cid"));
		Double orderValue = calcOrderValue(oID); //issue when inputting calcOrderValue returns null along with values?--> RESOLVED
		List<Items> items = getAllItems(oID); 
		
		return new Orders(oID, customer, orderValue, items);
	}
	


}
