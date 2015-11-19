package app.IMAS.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="borrower")
public class Borrower implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BorrowerId")
	private int borrowerId;
	
	@NotEmpty(message="Enter Name")
	@Column(name="Name")
	private String borrowerName;
	
	@NotEmpty(message="Enter CNIC")
	@Column(name="CNIC")
	private String cnic;
	
	@NotEmpty(message="Enter Address")
	@Column(name="Address")
	private String address;
	
	@NotEmpty(message="Enter Contact Number")
	@Column(name="ContactNo")
	private String contactNumber;

	@javax.validation.constraints.NotNull(message="Enter Amount Remains")
	@Column(name="AmountRemains")
	private double debtAmount;
	
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getDebtAmount() {
		return debtAmount;
	}
	public void setDebtAmount(double debtAmount) {
		this.debtAmount = debtAmount;
	}
	
	
}
