package app.IMAS.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="borrowerbillsdetails")
public class BorrowerBillItems implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BBD_Id")
	private int bbdId;

	@Column(name="ItemName")
    private String itemName;
	
	@Column(name="ItemQuantity")
    private double itemQuantity;
	
	@Column(name="ItemPrice")
    private double itemPrice;
	
	@Column(name="WholePrice")
    private double totalItemPrice;
	
	@Column(name="Date")
	@Type(type = "date")
    private Date date;

	@ManyToOne
	@JoinColumn(name="Bill_Id", referencedColumnName="Bill_Id")
    private BorrowerBill borrowerBill;
	
    public int getBbdId() {
		return bbdId;
	}

	public void setBbdId(int bbdId) {
		this.bbdId = bbdId;
	}

	public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public BorrowerBill getBorrowerBill() {
		return borrowerBill;
	}

	public void setBorrowerBill(BorrowerBill borrowerBill) {
		this.borrowerBill = borrowerBill;
	}
    
}
