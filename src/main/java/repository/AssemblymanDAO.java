package repository;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import mapper.ManMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import vo.Assemblyman;
import vo.Assemblymen;

@Component
public class AssemblymanDAO {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
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
	
	public void creat(int updateTAG, Assemblymen assemblymen) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		//TransactionStatus status = transactionManager.getTransaction(def);
		
		ManMapper mapper=session.getMapper(ManMapper.class);
		for (Assemblyman man : assemblymen.getAssemblymen()) {
			
			System.out.println(man);
			man.setUpdate_tag(updateTAG + 1);
			mapper.insert(man);
			System.out.println("Inserted into Customer Table Successfully" + man.getAssemblyman_id());
			
			/*try{
				//처음 insert update_tag = 1
				man.setUpdate_tag(updateTAG + 1);
				mapper.insert(man);
				System.out.println("Inserted into Customer Table Successfully" + man.getAssemblyman_id());
			} catch(Exception e) {
				
//				String manId = man.getAssemblyman_id();
				man.setUpdate_tag(updateTAG + 1);
				int result = mapper.update(man);
				System.out.println("Inserted into Customer Table Successfully" + man.getAssemblyman_id());
				
				if(result == 0){
					throw new RuntimeException("insert & update 모두 error!!" + man);
				}
		
			}*/
		}
		
	}

}
