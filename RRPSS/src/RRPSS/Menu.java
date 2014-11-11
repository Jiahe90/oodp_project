/**
 * The Restaurants ArrayList of promotions and menu items.
 * @author Bob
 * @version 1.0
 * @since 2014-10-19
 */

package RRPSS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import RRPSS.MenuItem.MenuItemType;

public class Menu {

	private Collection<MenuItem> menuItemList;
	private Collection<PromoItem> promoDealList;

	
	/**
	 * Generates ArrayList of MenuItem and PromoItem.
	 */
	public Menu() {
		menuItemList = new ArrayList<MenuItem>();
		promoDealList = new ArrayList<PromoItem>();
	}
	
	public Collection<PromoItem> getPromoDealList() {
		return this.promoDealList;
	}

	/**
	 * Assigns promoDealList into the array.
	 * @param promoDealList		Collection of all promotions.
	 */
	public void setPromoDealList(Collection<PromoItem> promoDealList) {
		this.promoDealList = promoDealList;
	}

	public Collection<MenuItem> getMenuItemList() {
		return this.menuItemList;
	}

	/**
	 * Assigns menuItemList into the array.
	 * @param menuItemList		Collection of all menu items.
	 */
	public void setMenuItemList(Collection<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * Adds a new menu item into the menuItemList.
	 * @param name			The name of the menu item.
	 * @param description 	The description of the menu item.
	 * @param price 		The price of the menu item.
	 * @param type 			The category type that the menu item belongs in.
	 */
	public void createMenuItem(String name, String description, double price, MenuItemType type) {
		menuItemList.add(new MenuItem(name, description, price , type));
	}

	/**
	 * Updates a particular menu item in itemMenuList.
	 * @param name			The name of the to-be-updated menu item.
	 */
	public void updateMenuItem(String name) {

		MenuItem item = getMenuItem(name);
		int option, index = 0, typeOption;
		double updatePrice;
		String updateDescription, updateName;
		Scanner sc = new Scanner(System.in);
		
		if (item == null) {
			System.out.println("Item is not in menu");
			return;
		} else {
			System.out.println("Changing item name: " + item.getName() + " | Price: " + item.getPrice() + " "
			+ "| Description: " + item.getDescription() + " | Type: " + item.getType());
		}
		
		/*
		for (int i = 0; i < menuItemList.size(); i++) {
			if (item.getName().equals(name)) {
				index = i;
				break;
			}
		}
		*/
		
		do {
			System.out.println("1. Update name");
			System.out.println("2. Update price");
			System.out.println("3. Update description");
			System.out.println("4. Update item type");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();
			
			switch(option) {
				case 1:
						System.out.print("Enter new name: ");
						updateName = sc.next();
						sc.nextLine();
						item.setName(updateName);
						break;
				case 2:	
						System.out.print("Enter new price: ");
						updatePrice = sc.nextDouble();
						item.setPrice(updatePrice);
						break;
				case 3:
						System.out.print("Enter new description: ");
						updateDescription = sc.next();
						sc.nextLine();
						item.setDescription(updateDescription);
						break;
				case 4: 
						System.out.println("1. Set as Main Course | 2. Set as Drink | 3. Set as Dessert | 4. Set as Appetizer");
						System.out.print("Enter new item type: ");
						typeOption = sc.nextInt();
						if (typeOption == 1) item.setType(MenuItemType.MAIN_COURSE);
						else if (typeOption == 2) item.setType(MenuItemType.DRINK);
						else if (typeOption == 3) item.setType(MenuItemType.DESSERT);
						else item.setType(MenuItemType.APPETIZER);
						break;
			}
		} while(option < 5);
		
		
		System.out.println("New updated menu item added: " + item.getName() + " | Price: " + item.getPrice() + " | Description: " 
		+ item.getDescription() + " | Type: " + item.getType());
		
		/*
		menuItemList.remove(index);
		menuItemList.add(new MenuItem(item.getName(), item.getPrice(), item.getDescription(), item.getType())); 
		*/
	}

	/**
	 * Removes an item from the menu. 
	 * Returns TRUE if item is successfully removed from menuItemList.
	 * Returns FALSE if item not found in menuItemList.
	 * @param name		The name of the to-be-removed menu item.
	 */
	public boolean deleteMenuItem(String name) {
		int index = 0;
		MenuItem item = getMenuItem(name);
		
		if (item == null) return false;
		else {
			for (int i = 0; i < menuItemList.size(); i++) {
				if (item.getName().equals(name)) {
					index = i;
					break;
				}
			}
			menuItemList.remove(index);
			return true;
		}
	}

	/**
	 * Search the menuItemList for a particular item, if item not found returns null.
	 * @param return	Return property of current menu item.
	 */
	public MenuItem getMenuItem(String name) {
		for (MenuItem item : menuItemList)
			   if (item.getName().equals(name)) return item;
		return null;
	}

	/**
	 * Adds a new promotion into the promoDealList.
	 * Prints out every added menu item into the promotion.
	 * @param name			The name of promotion.
	 * @param price			The price of promotion.
	 * @param description	The description of promotion.
	 */
	public void createPromoDeal(String name, double price, String description) {
		int option = 0, index = 1, addPromotion;
		Scanner sc = new Scanner(System.in);
		
		PromoItem promotion = new PromoItem(name, description, price);
		
		if (menuItemList.isEmpty() == true) {
			System.out.println("No items in the menu, please add items into the menu");
			return;
		}
		
		do {
			System.out.println("1. Add an item from the menu list into the promotion");
			System.out.println("2. Exit");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();
			
			switch (option) {
				case 1:	
						do {
						System.out.println("Current menu items available in the menu: ");
						for (MenuItem item : menuItemList) {
							System.out.println(index + ". " + item.getName());
							index++;
						}
						System.out.print("Select an item from the menu list (-1 to exit): ");
						addPromotion = sc.nextInt();
						MenuItem menuItem = ((ArrayList<MenuItem>) menuItemList).get(addPromotion - 1);
						System.out.println("Menu item " + menuItem.getName() + " added into the promotion");
						promotion.addMenuItem(menuItem);
						} while (addPromotion != -1);
						break;
			}
		} while(option < 2);
		
		promoDealList.add(new PromoItem(promotion.getName(), promotion.getDescription(), promotion.getPrice()));
	}

	/**
	 * Updates a particular promotion item in promoDealList.
	 * @param name		The name of to-be-updated promotion.
	 */
	public void updatePromoDeal(String name) {
		PromoItem item = getPromoDeal(name);
		int option, addPromotion, index = 0;
		double updatePrice;
		String updateName, updateDescription;
		Scanner sc = new Scanner(System.in);
		
		if (item == null) {
			System.out.println("Promotion not inside list of promotions");
			return;
		}
		
		do {
			System.out.println("1. Update name");
			System.out.println("2. Update price");
			System.out.println("3. Update description");
			System.out.println("4. Add additional menu item");
			System.out.println("5. Remove a menu item");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();
			
			switch(option) {
				case 1: 
						System.out.print("Enter new name: ");
						updateName = sc.next();
						sc.nextLine();
						item.setName(updateName);
						break;
				case 2:
						System.out.print("Enter new price: ");
						updatePrice = sc.nextDouble();
						item.setPrice(updatePrice);
						break;
				case 3: 
						System.out.print("Enter new description: ");
						updateDescription = sc.next();
						sc.nextLine();
						item.setDescription(updateDescription);
						break;
				case 4:
						do {
						System.out.println("Current menu items available in the menu: ");
						for (MenuItem i : menuItemList) {
							System.out.println(index + ". " + i.getName());
							index++;
						}
						System.out.print("Select an item from the menu list (-1 to exit): ");
						addPromotion = sc.nextInt();
						MenuItem menuItem = ((ArrayList<MenuItem>) menuItemList).get(addPromotion);
						System.out.println("Menu item " + menuItem.getName() + " added into the promotion");
						item.addMenuItem(menuItem);
						} while (addPromotion != -1);
						break;
				case 5:	
					do {
						System.out.println("Current menu items available in the menu: ");
						for (MenuItem i : menuItemList) {
							System.out.println(index + ". " + i.getName());
							index++;
						}
						System.out.print("Select an item from the menu list (-1 to exit): ");
						addPromotion = sc.nextInt();
						MenuItem menuItem = ((ArrayList<MenuItem>) menuItemList).get(addPromotion);
						System.out.println("Menu item " + menuItem.getName() + " removed from the promotion");
						item.removeMenuItem(menuItem);
						} while (addPromotion != -1);
						break;
			}
		} while(option < 6);
	}

	/**
	 * Removes an item from the menu. 
	 * Returns TRUE if item is successfully removed from promoDealList.
	 * Returns FALSE if item not found in promoDealList.
	 * @param name		The name of the to-be-removed promotion.
	 */
	public boolean deletePromoDeal(String name) {
		int index = 0;
		PromoItem item = getPromoDeal(name);
		
		if (item == null) return false;
		else {
			for (int i = 0; i < promoDealList.size(); i++) {
				if (item.getName().equals(name)) {
					index = i;
					break;
				}
			}
			promoDealList.remove(index);
			return true;
		}
	}

	/**
	 * Search the promoDealList for a particular item, if item not found returns null.
	 * @param return	Return property of current promotion item.
	 */
	public PromoItem getPromoDeal(String name) {
		for (PromoItem item : promoDealList)
			   if (item.getName().equals(name)) return item;
		return null;
	}

}