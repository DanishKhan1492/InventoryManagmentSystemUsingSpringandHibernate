package app.IMAS.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cat_Id")
	private int catId;
	@Column(name="Cat_Name",unique=true)
	private String catName;
	@Column(name="Cat_Unit)")
	private String catUnit;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private Set<Product> products;  
	
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatUnit() {
		return catUnit;
	}
	public void setCatUnit(String catUnit) {
		this.catUnit = catUnit;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
