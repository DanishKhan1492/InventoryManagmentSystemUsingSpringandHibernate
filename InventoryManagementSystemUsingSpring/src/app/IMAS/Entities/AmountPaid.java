package app.IMAS.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="amountpaid")
public class AmountPaid implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Pid")
	private int id;
	
	@NotEmpty(message="Enter Cnic Number ")
	@Column(name="CNIC")
	private String cnic;
	
	@Column(name="LastAmount")
	private double lastAmount;
	
	@NotNull(message="Enter Amount")
	@Column(name="Paid")
	private double paymentAmount;
	
	@Column(name="remainingAmount")
	private double amountRemaining;

	@Column(name="Date")
	@Type(type = "date")
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public double getLastAmount() {
		return lastAmount;
	}
	public void setLastAmount(double lastAmount) {
		this.lastAmount = lastAmount;
	}

	public double getAmountRemaining() {
		return amountRemaining;
	}
	public void setAmountRemaining(double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
