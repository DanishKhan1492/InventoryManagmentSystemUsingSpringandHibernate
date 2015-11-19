package app.IMAS.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cat_Id")
	private int catId;
	
	@NotEmpty(message="Enter Category Name") // Validator
	@Column(name="Cat_Name",unique=true)
	private String catName;
	
	@NotEmpty(message="Enter Cat Unit") //Validator
	@Column(name="Cat_Unit")
	private String catUnit;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="itemCategory",targetEntity=Product.class) //Mapping One to Many to Product Unique Ket of Category Table
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
