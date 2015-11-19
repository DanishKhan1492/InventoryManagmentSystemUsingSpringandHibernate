package app.IMAS.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="amountborrowed")
public class AmountBorrowed implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BorrowedId")
	private int borrowerdId;
	
	@Column(name="LastAmount")
	private double lastAmount;
	
	@Column(name="NewAmount")
	private double newAmount;
	
	@Column(name="TotalAmount")
	private double totalAmount;
	
	@Column(name="Date")
	@Type(type = "date")
	private Date date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CNIC", referencedColumnName="CNIC")
	private Borrower cnic;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Bill_id", referencedColumnName="Bill_Id")
	private BorrowerBill billId;

	
	public int getBorrowerdId() {
		return borrowerdId;
	}

	public void setBorrowerdId(int borrowerdId) {
		this.borrowerdId = borrowerdId;
	}

	public double getLastAmount() {
		return lastAmount;
	}

	public void setLastAmount(double lastAmount) {
		this.lastAmount = lastAmount;
	}

	public double getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(double newAmount) {
		this.newAmount = newAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Borrower getCnic() {
		return cnic;
	}

	public void setCnic(Borrower cnic) {
		this.cnic = cnic;
	}

	public BorrowerBill getBillId() {
		return billId;
	}

	public void setBillId(BorrowerBill billId) {
		this.billId = billId;
	}
	
	
	
	
}
