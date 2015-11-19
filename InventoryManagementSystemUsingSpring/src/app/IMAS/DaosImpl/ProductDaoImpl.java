package app.IMAS.DaosImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.IMAS.Daos.ProductDao;
import app.IMAS.Entities.Price;
import app.IMAS.Entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addItem(Product additem) {
		sessionFactory.getCurrentSession().save(additem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllItems() {
		List<Product> productList=new ArrayList<>();
		productList=(List<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
		return productList;
	}

	@Override
	public Product searchItems(String itemName) {
		Product productList=new Product();
		productList=(Product)sessionFactory.getCurrentSession().createQuery("from Product Where Prod_Name=:name").setString("name",itemName).uniqueResult();
		return productList;
	}

	@Override
	public void updateItems(Product updateitems) {
		sessionFactory.getCurrentSession().update(updateitems);
	}

	@Override
	public Product getItemsforupdate(String itemName) {
		Product product=new Product();
		product=(Product) sessionFactory.getCurrentSession().createQuery("from Product Where Prod_Name=:name").setString("name", itemName).uniqueResult();
		return product;
	}

	@Override
	public void deleteItems(int deleteId) {
		sessionFactory.getCurrentSession().createQuery("delete from Product Where Prod_Id=:id").setInteger("id", deleteId).executeUpdate();
	}

	@Override
	public Product getPrice(int itemid) {
		Product product=new Product();
		product=(Product) sessionFactory.getCurrentSession().createQuery("from Product Where Prod_Id=:id").setInteger("id", itemid).uniqueResult();
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getItemNames(String categoryName) {
		List<String> itemNamesList=new ArrayList<>();
		List<Product> productList=new ArrayList<>();
		productList=(List<Product>) sessionFactory.getCurrentSession().createQuery("from Product Where Cat_Name=:catName").setString("catName", categoryName).list();
		
		for(Product product:productList){
			itemNamesList.add(product.getItemName());
		}
		
		return itemNamesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchItemsByAnyValue(String itemName) {
		List<Product> productList=new ArrayList<>();
		productList=(List<Product>)sessionFactory.getCurrentSession().createQuery("from Product Where Prod_Name LIKE :name").setString("name","%"+itemName+"%").list();
		return productList;
	}

	@Override
	public void changePrice(Price price) {
		sessionFactory.getCurrentSession().save(price);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Price> getSpecificPrice(String itemName) {
		List<Price> prices=(List<Price>) sessionFactory.getCurrentSession().createQuery("from Price Where Prod_Name=:name").setString("name", itemName).list();
		return prices;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Price> getAllPrice() {	
		return (List<Price>) sessionFactory.getCurrentSession().createQuery("from Price").list();
	}
	
}
