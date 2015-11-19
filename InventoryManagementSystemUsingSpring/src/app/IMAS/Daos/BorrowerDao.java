package app.IMAS.Daos;

import java.util.Date;
import java.util.List;

import app.IMAS.Entities.AmountBorrowed;
import app.IMAS.Entities.AmountPaid;
import app.IMAS.Entities.Borrower;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;

public interface BorrowerDao {
	public List<Borrower> getAllBorrowers();
    public void addBorrwer(Borrower borrower);
    public Borrower searchBorrowerByCnic(String cnic);
    public List<Borrower> searchBorrowerByName(String borrowerName);
    public void updateBorrower(Borrower borrower);
    public void deleteBorrower(String cnic);
    public void amountPaid(AmountPaid amountPaid);
    
    public Borrower getSpecificBorrower(String cnic);
    public List<BorrowerBill> getBorrowerBills(String cnic);
    public List<BorrowerBillItems> getBillItems(int billId);
    public List<AmountBorrowed> getAllBorrowedAmounts(String cnic);
    public List<AmountPaid> getAllPaidAmounts(String cnic);
    public List<BorrowerBill> getBorrowerBills(String cnic, Date date);
    public List<AmountBorrowed> getAllBorrowedAmounts(String cnic,Date date);
    public List<AmountPaid> getAllPaidAmounts(String cnic,Date date);
    public String billId(String tableName);
    public double getPrice(String itemName);
}
