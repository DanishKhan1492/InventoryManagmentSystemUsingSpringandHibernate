package app.IMAS.Daos;

import java.util.List;

import app.IMAS.Entities.Product;

public interface ProductDao {
	
	public void addItem(Product additem);

	public List<Product> getAllItems();

	public List<Product> searchItems(String itemName);

	public void updateItems(Product updateitems);

	public Product getItemsforupdate(int updateId);

	public void deleteItems(int deleteId);

	public Product getPrice(int itemid);

	public List<String> getItemNames(String categoryName);

	/*public int changePrice(PriceEntity price);*/
}
