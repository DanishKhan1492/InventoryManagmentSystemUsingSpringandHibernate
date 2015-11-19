package app.IMAS.DaosImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.IMAS.Daos.CategoryDao;
import app.IMAS.Entities.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public void addCategory(Category category) {
		session.getCurrentSession().save(category);
	}

	@Override
	public void updateCategory(Category category) {
		session.getCurrentSession().update(category);
	}

	@Override
	public void deleteCategory(int catId) {
		session.getCurrentSession().createQuery("delete from Category Where Cat_Id=:catId").setInteger("catId",catId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		return (List<Category>)session.getCurrentSession().createQuery("from Category").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> searchCategory(String catName) {
		return (List<Category>) session.getCurrentSession().createQuery("from Category Where Cat_Name LIKE :name").setString("name", "%"+catName+"%").list();
	}

	@Override
	public String getCategory(String itemName) {
		Category category=new Category();
		category=(Category) session.getCurrentSession().createQuery("from Category Where Cat_Name=:name").setString("name", itemName).uniqueResult();
		String catName=category.getCatName();
		return catName;
	}

	@Override
	public Category getWholeCategory(String categoryName) {
		Category category=new Category();
		category=(Category) session.getCurrentSession().createQuery("from Category Where Cat_Name=:name").setString("name", categoryName).uniqueResult();
		return category;
	}
	
}
