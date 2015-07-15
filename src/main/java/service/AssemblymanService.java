package service;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import repository.AssemblymanDAO;
import vo.Assemblyman;
import vo.Assemblymen;

@Component
@Transactional
public class AssemblymanService {
	
	private AssemblymanDAO assemblymanDAO;
	
	@Autowired
	public void setAssemblymanDAO(AssemblymanDAO assemblymanDAO) {
		this.assemblymanDAO = assemblymanDAO;
	}
	
	private DataSourceTransactionManager transactionManager;
	
	//////////////////////////////////////////////////////////////////
	public int insert(Assemblyman man){
		return assemblymanDAO.insert(man);
	}
	public int update(Assemblyman man){
		return assemblymanDAO.update(man);
	}
	public Assemblyman selectAssemblyman(String manId){
		return assemblymanDAO.selectAssemblyman(manId);
	}
	public List<Assemblyman> selectList(){
		return assemblymanDAO.selectList();
	}

	public int selectUpdate() {
		return assemblymanDAO.selectUpdate();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveData(int updateTAG, Assemblymen assemblymen) throws Exception {
		assemblymanDAO.creat(updateTAG, assemblymen);
		/*
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("SomeTxName");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(def);
		
		try{
			for (Assemblyman man : assemblymen.getAssemblymen()) {
				
				System.out.println(man);
				String manId = man.getAssemblyman_id();
				man.setAssemblyman_id(manId);
				
					//처음 insert update_tag = 1
					man.setUpdate_tag(updateTAG + 1);
					assemblymanDAO.insert(man);
					System.out.println("Inserted into Customer Table Successfully" + man.getAssemblyman_id());
			}
		} catch(Exception e){
			throw e;
		}
		/*
		for (Assemblyman man : assemblymen.getAssemblymen()) {
			
			// mo_dttm 을 insert 시간으로 변경
			Date date = new Date();
			man.setMod_dttm(date.toString());
			System.out.println(date.toString());
			System.out.println(man);
			String manId = man.getAssemblyman_id();
			man.setAssemblyman_id(manId);
			
			try{
				//처음 insert update_tag = 1
				man.setUpdate_tag(updateTAG + 1);
				assemblymanDAO.insert(man);
				
			} catch(Exception e) {
				
				
				man.setUpdate_tag(updateTAG + 1);
				int result = assemblymanDAO.update(man);
				
				if(result == 0){
					throw new RuntimeException("insert & update 모두 error!!" + man);
				}
		
			}
		}*/
	}
	
}
