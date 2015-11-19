package app.IMAS.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.IMAS.Daos.ProductDao;
import app.IMAS.Entities.Price;
import app.IMAS.Entities.Product;
import app.IMAS.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void addItem(Product additem) {
		productDao.addItem(additem);
	}

	@Transactional
	public List<Product> getAllItems() {
		return productDao.getAllItems();
	}

	@Transactional
	public Product searchItems(String itemName) {
		return productDao.searchItems(itemName);
	}

	@Transactional
	public void updateItems(Product updateitems) {
		productDao.updateItems(updateitems);
	}

	@Transactional
	public Product getItemsforupdate(String itemName) {
		return productDao.getItemsforupdate(itemName);
	}

	@Transactional
	public void deleteItems(int deleteId) {
		productDao.deleteItems(deleteId);
	}

	@Transactional
	public Product getPrice(int itemid) {
		return productDao.getPrice(itemid);
	}

	@Transactional
	public List<String> getItemNames(String categoryName) {
		return productDao.getItemNames(categoryName);
	}

	@Transactional
	public List<Product> searchItemsByAnyValue(String itemName) {
		return productDao.searchItemsByAnyValue(itemName);
	}

	@Transactional
	public void changePrice(Price price) {
		productDao.changePrice(price);
	}

	@Transactional
	public List<Price> getSpecificPrice(String itemName) {
		return productDao.getSpecificPrice(itemName);
	}

	@Transactional
	public List<Price> getAllPrice() {
		return productDao.getAllPrice();
	}

}
