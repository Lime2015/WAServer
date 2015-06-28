package mapper;

import java.util.List;

import vo.bill.Bill;

public interface BillMapper {

	public int insert(Bill bill);
	public int update(Bill bill);
	public Bill selectBill(String bill_no);
	public List<Bill> selectList();

}
