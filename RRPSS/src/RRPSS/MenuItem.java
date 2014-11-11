/**
 * A menu item that people will consume in their meal.
 * An order can contain multiple menu items.
 * @author Koh Eng Han, Dois
 * @version 1.0
 * @since 2014-10-19
 */
package RRPSS;

public class MenuItem {
	
	/**
	 * Different categories for the menu items
	 * @author Dois
	 */
	public enum MenuItemType {
		MAIN_COURSE,
		DRINK,
		DESSERT,
		APPETIZER
	}
	
	/**
	 * The name of the menu item.
	 */
	private String name;
	
	/**
	 * A brief description of the menu item.
	 */
	private String description;
	
	/**
	 * The price of the menu item.
	 */
	private double price;
	
	/**
	 * The category type that the menu item belongs in.
	 */
	private MenuItemType type;
	
	/**
	 * Creates a new menu item along with all possible attributes.
	 * @param name			The name of the menu item.
	 * @param description 	The description of the menu item.
	 * @param price 		The price of the menu item.
	 * @param type 			The category type that the menu item belongs in.
	 */
	public MenuItem(String name, String description, double price, MenuItemType type) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
	}
	
	/**
	 * Gets the name of the menu item.
	 * @return The name of the menu item.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Changes the name of the menu item.
	 * @param name The new name of the menu item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the price of the menu item.
	 * @return The price of the menu item.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Change the price of the menu item.
	 * @param price The new price of the menu item.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets the description of the menu item.
	 * @return The description of the menu item.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Changes the description of the menu item.
	 * @param description The new description of the menu item.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the type of the menu item.
	 * @return The type of the menu item.
	 */
	public MenuItemType getType() {
		return type;
	}
	
	/**
	 * Changes the type of the menu item.
	 * @param type The type of the menu item.
	 */
	public void setType(MenuItemType type) {
		this.type = type;
	}
}
