package repository;

import java.util.Date;
import java.util.List;

import mapper.ManMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vo.Assemblyman;
import vo.Assemblymen;

@Component
public class AssemblymanDAO {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	//////////////////////////////////////////////////

	public int insert(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return mapper.insert(man);
	}

	public int update(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return mapper.update(man);
	}

	public Assemblyman selectAssemblyman(String manId) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return mapper.selectAssemblyman(manId);
	}

	public List<Assemblyman> selectList() {
		ManMapper mapper=session.getMapper(ManMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		ManMapper mapper=session.getMapper(ManMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void create(int updateTAG, Assemblymen assemblymen) throws Exception {
		try {

			ManMapper mapper = session.getMapper(ManMapper.class);

			for (Assemblyman man : assemblymen.getAssemblymen()) {
				
				// mo_dttm 을 insert 시간으로 변경
				Date date = new Date();
				man.setMod_dttm(date.toString());
				man.setUpdate_tag(updateTAG + 1);
				System.out.println("updateTAG :" + updateTAG);
				
				try{
					System.out.println(man);
					mapper.insert(man);
					System.out.println("Inserted into Date Table Successfully" 	+ man.getAssemblyman_id());
				
				} catch(Exception e){
					int result = mapper.update(man);
					System.out.println("Update Customer Date Successfully" + man.getAssemblyman_id());
					
					if(result == 0){ 
						throw new RuntimeException("Insert & Update error!!" + man.getAssemblyman_id()); 
						}
					
				}
			}
		} catch (Exception e) {
			throw e;
		}

		
		
		/*
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("SomeTxName");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			ManMapper mapper = session.getMapper(ManMapper.class);

			for (Assemblyman man : assemblymen.getAssemblymen()) {

				System.out.println(man);
				man.setUpdate_tag(updateTAG + 1);
				mapper.insert(man);
				System.out.println("Inserted into Customer Table Successfully"
						+ man.getAssemblyman_id());
			}
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}

		transactionManager.commit(status);
		*/
		
		/*
		 * try{ //처음 insert update_tag = 1 man.setUpdate_tag(updateTAG + 1);
		 * mapper.insert(man);
		 * System.out.println("Inserted into Customer Table Successfully" +
		 * man.getAssemblyman_id()); } catch(Exception e) {
		 * 
		 * // String manId = man.getAssemblyman_id();
		 * man.setUpdate_tag(updateTAG + 1); 
		 * int result = mapper.update(man);
		 * System.out.println("Inserted into Customer Table Successfully" +
		 * man.getAssemblyman_id());
		 * 
		 * if(result == 0){ throw new
		 * RuntimeException("insert & update 모두 error!!" + man); }
		 * 
		 * }
		 */
	}	

}
