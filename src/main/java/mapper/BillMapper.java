package mapper;

import java.util.List;

import vo.bill.Bill;

public interface BillMapper {

	public int insert(Bill bill);
	public int update(Bill bill);
	public Bill selectBill(int bill_id);
	public List<Bill> selectList();

}
