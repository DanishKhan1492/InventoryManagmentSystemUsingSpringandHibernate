package app.IMAS.Services;

import java.util.List;

import app.IMAS.Entities.Price;
import app.IMAS.Entities.Product;

public interface ProductService {
	public void addItem(Product additem);

	public List<Product> getAllItems();

	public Product searchItems(String itemName);

	public void updateItems(Product updateitems);

	public Product getItemsforupdate(String itemName);

	public void deleteItems(int deleteId);

	public Product getPrice(int itemid);

	public List<String> getItemNames(String categoryName);

	public List<Product> searchItemsByAnyValue(String itemName);

	public void changePrice(Price price);
	
	public List<Price> getSpecificPrice(String itemName);

	public List<Price> getAllPrice();
}
