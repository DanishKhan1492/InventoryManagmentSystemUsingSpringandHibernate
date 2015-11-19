package app.IMAS.ServicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import app.IMAS.Daos.ProductDao;
import app.IMAS.Entities.Product;
import app.IMAS.Services.ProductService;

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
	public List<Product> searchItems(String itemName) {
		return productDao.searchItems(itemName);
	}

	@Transactional
	public void updateItems(Product updateitems) {
		productDao.updateItems(updateitems);
	}

	@Transactional
	public Product getItemsforupdate(int updateId) {
		return productDao.getItemsforupdate(updateId);
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

}
