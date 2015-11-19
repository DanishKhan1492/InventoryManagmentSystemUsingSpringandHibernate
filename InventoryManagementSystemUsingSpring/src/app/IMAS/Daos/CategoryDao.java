package app.IMAS.Daos;

import java.util.List;
import app.IMAS.Entities.Category;

public interface CategoryDao {
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(int catId);
	public List<Category> getAllCategories();
	public List<Category> searchCategory(String catName);
	public String getCategory(String itemName);
	
}
