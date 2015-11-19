package app.IMAS.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.IMAS.Daos.CategoryDao;
import app.IMAS.Entities.Category;
import app.IMAS.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional	
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Transactional
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	@Transactional
	public void deleteCategory(int catId) {
		categoryDao.deleteCategory(catId);
	}

	@Transactional
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Transactional
	public List<Category> searchCategory(String catName) {
		return categoryDao.searchCategory(catName);
	}

	@Transactional
	public String getCategory(String itemName) {
		return categoryDao.getCategory(itemName);
	}

	@Transactional
	public Category getWholeCategory(String categoryName) {
		Category category=new Category();
		category=categoryDao.getWholeCategory(categoryName);
		return category;
	}

}
