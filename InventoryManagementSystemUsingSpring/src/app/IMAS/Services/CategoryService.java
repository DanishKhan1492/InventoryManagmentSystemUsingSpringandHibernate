package app.IMAS.Services;

import java.util.List;

import app.IMAS.Entities.Category;

public interface CategoryService {
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(int catId);
	public List<Category> getAllCategories();
	public List<Category> searchCategory(String catName);
	public String getCategory(String itemName);
	public Category getWholeCategory(String categoryName);
}
