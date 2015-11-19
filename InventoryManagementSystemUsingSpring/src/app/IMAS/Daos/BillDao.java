package app.IMAS.Daos;


import java.util.List;

import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;

public interface BillDao {
	public void insertBill(BorrowerBill billMain, List<BorrowerBillItems> billItems);
    public List<BorrowerBill> getAllBills();
    public BorrowerBill getSpecificBill(String cnic);
    public List<BorrowerBillItems> getAllBillItems(int billId);
}
