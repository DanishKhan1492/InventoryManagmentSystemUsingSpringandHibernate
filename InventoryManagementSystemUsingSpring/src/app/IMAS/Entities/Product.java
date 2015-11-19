package app.IMAS.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Prod_Id")
	private int itemId;
	
	@NotEmpty(message="Enter Product Name")
	@Column(name="Prod_Name",unique=true)
	private String itemName;
	
	@javax.validation.constraints.NotNull(message="Enter Quantity")
	@Column(name="Prod_Quantity")
	private double itemQuantity;
	
	@javax.validation.constraints.NotNull(message="Enter Quantity")
	@Column(name="Prod_Price")
	private double itemPrice;

	@ManyToOne
	@JoinColumn(name="Cat_Name",referencedColumnName="Cat_Name") // Foreign Key For Product and Unique Key of Category
	private Category itemCategory;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product", targetEntity=Price.class)
	private Set<Price> prices;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Category getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	
	
}
