/**
 * A order that will contain what customer had ordered. Also table, staff and totalBill.
 * @author 
 * @version 1.0
 * @since 2014-11-08
 */
package RRPSS;

import java.util.ArrayList;
import java.util.Collection;

public class Order {
	/**
	 * The unique id for order.
	 */
	private int orderId;
	
	/**
	 * The staff that took the order.
	 */
	private Staff orderTaker;
	
	/**
	 * The collection of menu item ordered
	 */
	private Collection<MenuItem> menuItemList;
	
	/**
	 * The collection of promotion item ordered
	 */
	private Collection<PromoItem> promoDealList;
	
	/**
	 * The total bill calculated from ordered items.
	 */
	private double totalBill;
	
	/**
	 * The table that assigned to the customer.
	 */
	private Table table;
	
	/**
	 * Creates a new order with all the attributes.
	 * @param orderId		The unique id of the order.
	 * @param orderTaker	The staff that that issue the order.
	 * @param table			The table that assigned to the customer.
	 */
	public Order(int orderId, Staff orderTaker, Table table) {
		this.orderId = orderId;
		this.orderTaker = orderTaker;
		menuItemList = new ArrayList<MenuItem>();
		promoDealList = new ArrayList<PromoItem>();
		this.table = table;
	}
	
	/**
	 * Gets the id of this order.
	 * @return The order id of this order.
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * Changes the id of this order.
	 * @param orderId The new id of this order.
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Gets the staff that issue the order.
	 * @return
	 */
	public Staff getOrderTaker() {
		return orderTaker;
	}
	
	/**
	 * Changes the staff that issue the order.
	 * @param orderTaker The new staff of this order.
	 */
	public void setOrderTaker(Staff orderTaker) {
		this.orderTaker = orderTaker;
	}
	
	/**
	 * Gets the collection of all menu item from the order.
	 * @return The collection of menu item from the order.
	 */
	public Collection<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	
	/**
	 * Changes the collection of menu item for the order.
	 * @param menuItemList The new collection of menu items.
	 */
	public void setMenuItemList(Collection<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	/**
	 * Gets the collection of promotion items from the order.
	 * @return The collection of promotion item from the order.
	 */
	public Collection<PromoItem> getPromoDealList() {
		return promoDealList;
	}
	
	/**
	 * Changes the collection of promotion item for the order.
	 * @param promoDealList The new collection of promotion item for the order.
	 */
	public void setPromoDealList(Collection<PromoItem> promoDealList) {
		this.promoDealList = promoDealList;
	}
	
	/**
	 * Gets the total bill of the order.
	 * @return The total bill
	 */
	public double getTotalBill() {
		for (MenuItem menuItem : menuItemList) {
			totalBill += menuItem.getPrice();
		}
		
		for (PromoItem promoItem : promoDealList) {
			totalBill += promoItem.getPrice();
		}
		return totalBill;
	}
	
	/**
	 * Changes the total bill of the order.
	 * @param totalBill The new bill.
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	/**
	 * Gets the table assigned to the customer.
	 * @return The table that was used.
	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * Changes the table that was used.
	 * @param table The new table.
	 */
	public void setTable(Table table) {
		this.table = table;
	}
	
	/**
	 * Adds new menu item into the order.
	 * @param menuItem New menu item to be added.
	 */
	public void addMenuItem(MenuItem menuItem) {
		menuItemList.add(menuItem);
	}
	
	/**
	 * Removes menu item from the order.
	 * @param name Menu item that will be remove.
	 * @return A status to indicate success/failure.
	 */
	public boolean removeMenuItem(String name) {
		boolean status = false;
		for (MenuItem menuItem : menuItemList) {
			if(menuItem.getName().equals(name)) {
				menuItemList.remove(menuItem);
				status = true;
			}
		}
		return status;
	}
	
	/**
	 * Adds new promotion item into the order.
	 * @param promoItem New promotion item to be added.
	 */
	public void addPromoItem(PromoItem promoItem) {
		promoDealList.add(promoItem);
	}
	
	/**
	 * Removes promotion item from the order.
	 * @param name Promotion item that will be remove.
	 * @return A status to indicate success/failure.
	 */
	public boolean removePromoItem(String name) {
		boolean status = false;
		for (PromoItem promoItem : promoDealList) {
			if(promoItem.getName().equals(name)) {
				promoDealList.remove(promoItem);
				status = true;
			}
		}
		return status;
	}
}
