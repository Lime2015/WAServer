package repository;

import java.util.List;

import mapper.BillMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vo.bill.Bill;
import vo.bill.BillAssemblyman;
import vo.bill.BillInfo;

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

	public int selectUpdate() {
		BillMapper mapper = session.getMapper(BillMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void create(int updateTAG, BillInfo billInfo) throws Exception {
		BillMapper mapper = session.getMapper(BillMapper.class);
		try{
			for (BillAssemblyman man : billInfo.getAssemblymen()) {
					
				String assemblyman_id = man.getAssemblyman_id();
					
				for(Bill bill : man.getBills()){
						
					//bill 마다 assemblyman_id 를 추가 입력
					bill.setAssemblyman_id(assemblyman_id);
					bill.setUpdate_tag(updateTAG + 1);
					System.out.println("assemblyman_id : " + bill.getAssemblyman_id());
					
					try{
						//System.out.println(bill.getBill_no());
						mapper.insert(bill);
						System.out.println("Inserted into Customer Table Successfully" 	+ man.getAssemblyman_id());
							
						} catch(Exception e) {
							int result = mapper.update(bill);
							System.out.println("Update Customer Table Successfully" + man.getAssemblyman_id());
							if(result == 0){ 
								throw new RuntimeException("Insert & Update error!!" + man.getAssemblyman_id()); 
							}
						}
					}
				}
				
			}catch(Exception e){
				throw e;
			}
	}
}
