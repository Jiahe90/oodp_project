/**
 * A promo item that contains multiple menu items.
 * The price is not the summation of menu items.
 * It is a promotion! So the price is set separately by the restaurant.
 * An order can contain multiple promotions
 * @author Dois
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;
import java.util.Map;

public class PromoItem {
	
	/**
	 * The name of the promotional item.
	 */
	public String name;
	
	/**
	 * The description of the promotional item.
	 */
	public String description;
	
	/**
	 * The price of the promotional item.
	 */
	public double price;
	
	/**
	 * The list of menu items in this promotional item.
	 * Each menu item is associated with an Integer value that describes
	 * how many of that item is in this promotion.
	 * 	
	 * The key is a menu item and the value is the number of occurances of
	 * that menu item in this promotion
	 * 
	 * Example: <Hawaiian Pizza, 	1>
	 * 			<Soup of the Day, 	2>
	 * 
	 * For a promotion that contains 2 soups and 1 pizza.
	 * 
	 */
	public Map<MenuItem, Integer> promoMenuItems;
	
	/**
	 * Creates a promotional item and initializes its name,
	 * description and price. 
	 * @param name The name of the promotional item.
	 * @param description The description of the menu item.
	 * @param price The price of the menu item.
	 */
	public PromoItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	/**
	 * Gets the name of the promotional item.
	 * @return The name of the promotional item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Changes the name of the promotional item.
	 * @param name The new name of the promotional item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the price of the promotional item.
	 * @return The price of the promotional item.
	 */
	public double getPrice() { 
		return price;
	}
	
	/**
	 * Change the price of the promotional item.
	 * @param price The price of the promotional item.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets the description of the promotional item.
	 * @return The description of the promotional item.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Changes the description of the promotional item.
	 * @param description The description of the promotional item.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the collection of promotional items stored as key-value pairs (Map).
	 * @return The collection of promotional items and their associated values.
	 */
	public Map<MenuItem, Integer> getPromoMenuItems() {
		return promoMenuItems;
	}
	
	/**
	 * Changes the collection of promotional items.
	 * @param The new collection of promotional items.
	 */
	public void setPromoMenuItems(Map<MenuItem, Integer> promoMenuItems) {
		this.promoMenuItems = promoMenuItems;
	}
	
	/**
	 * Adds a menu item to this promotional item's collection.
	 * If the menu item already exists, the value is increased by one instead.
	 * 
	 * Example: There is already <Hawaiian Pizza, 2>. Adding "Hawaiian Pizza"
	 * again will increase the number of Hawaiian Pizzas in this promotional item
	 * by one to <Hawaiian Pizza, 3>
	 * @param menuItem The menu item to add to this promotional item.
	 * @return The new number of this menu item in this promotional item.
	 */
	public int addMenuItem(MenuItem menuItem) {
		
		if (promoMenuItems.containsKey(menuItem)) {
			int numberOfMenuItems = promoMenuItems.get(menuItem);
			promoMenuItems.replace(menuItem, numberOfMenuItems + 1);
			return numberOfMenuItems;
		} else {
			promoMenuItems.put(menuItem, 1);
			return 1;
		}
	}
	
	/**
	 * Removes a menu item from this promotiona item's collection.
	 * If the menu item already exists, the value is decreased by one instead.
	 * 
	 * Example: There is already <Hawaiian Pizza, 2>. Removing "Hawaiian Pizza"
	 *  will decrease the number of Hawaiian Pizzas in this promotional item
	 * by one to <Hawaiian Pizza, 1>
	 * @param menuItem The menu item to remove from this promotional item.
	 * @return The new number of this menu item in this promotional item.
	 */
	public int removeMenuItem(MenuItem menuItem) {
		if (promoMenuItems.containsKey(menuItem))
			return promoMenuItems.remove(menuItem);
		else
			return 0;
	}
}
