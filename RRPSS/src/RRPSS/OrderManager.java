/**
 * The OrderManager that manage the order of the customers.
 * @author 
 * @version 1.0
 * @since 2014-11-08
 */
package RRPSS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class OrderManager {
	/**
	 * The collection of orders in the restaurant.
	 */
	private Collection<Order> orderList;
	
	private static OrderManager orderManager;
	
	private static String orderFileName = "order.dat";
	
	/**
	 * Create a OrderManager and retrieve all order from flat file.
	 */
	private OrderManager() {
		orderList = new ArrayList<Order>();
		try {
			orderList = SerializeDB.readSerializedObject(orderFileName);
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}	
	}
	
	public static OrderManager getInstance() {
		if (orderManager == null)
			orderManager = new OrderManager();
		return orderManager;
	}
	
	/**
	 * Creates a new order
	 * @param orderTaker 	Staff the create the order.
	 * @param table			Table that was used in this order.
	 */
	public void createOrder(Staff orderTaker, Table table) {
		Order newOrder = new Order(orderList.size(), orderTaker, table);
		ArrayList temp = new ArrayList();
		temp.add(newOrder);
		SerializeDB.writeSerializedObject("Orders.dat", temp);
		orderList.add(newOrder);
	}
	
	/**
	 * Updates the order.
	 * @param orderId Id of order to be updated.
	 */
	public void updateOrder(int orderId) {
		for (Order order: orderList) {
			if (order.getOrderId() == orderId) {
				//update smlj? how?):
				updateOrderFile(orderFileName, orderList);
				break;
			}
		}
	}
	
	/**
	 * Deletes the specify order.
	 * @param orderId Id of order to be deleted.
	 */
	public void deleteOrder(int orderId) {
		for (Order order: orderList) {
			if (order.getOrderId() == orderId) {
				orderList.remove(order);
				updateOrderFile(orderFileName, orderList);
				break;
			}
		}
	}
	
	public void viewOrder(int orderId) {
		for (Order order: orderList) {
			if (order.getOrderId() == orderId) {
				//do what?
				break;
			}
		}
	}
	
	public Collection<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void printOrderInvoice(int orderId) {
		
	}
	
	public void printSalesRevenue(Calendar date) {
		
	}
	
	public Order getOrder(int orderId) {
		for (Order order: orderList) {
			if (order != null && order.getOrderId() == orderId) {
				return order;
			}
		}
		return null;
	}
	
	public void addItems(int orderId) {
		Order order = getOrder(orderId);
	}
	
	public void removeItems(int orderId) {
		Order order = getOrder(orderId);
	}
	
	private void updateOrderFile(String filename, Collection list) {
		SerializeDB.updateFile(filename, list);
	}
}
