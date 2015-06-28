package repository;

import java.util.List;

import mapper.BillMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.bill.Bill;

@Component
public class BillDAO {

	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(Bill bill) {
		BillMapper mapper = session.getMapper(BillMapper.class);
		return mapper.insert(bill);
	}

	public int update(Bill bill) {
		BillMapper mapper = session.getMapper(BillMapper.class);
		return mapper.update(bill);
	}

	public Bill selectBill(String bill_no) {
		BillMapper mapper = session.getMapper(BillMapper.class);
		return mapper.selectBill(bill_no);
	}

	public List<Bill> selectList() {
		BillMapper mapper = session.getMapper(BillMapper.class);
		return mapper.selectList();
	}
}
