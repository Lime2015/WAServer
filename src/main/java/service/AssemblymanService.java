package service;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import repository.AssemblymanDAO;
import vo.Assemblyman;
import vo.Assemblymen;

@Component
public class AssemblymanService {
	
	private AssemblymanDAO assemblymanDAO;
	
	@Autowired
	public void setAssemblymanDAO(AssemblymanDAO assemblymanDAO) {
		this.assemblymanDAO = assemblymanDAO;
	}
	
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
	
	@Transactional
	public void saveData(int updateTAG, Assemblymen assemblymen) throws Exception {
		assemblymanDAO.creat(updateTAG, assemblymen);
		
		/*
		for (Assemblyman man : assemblymen.getAssemblymen()) {
			
			// mo_dttm 을 insert 시간으로 변경
			Date date = new Date();
			man.setMod_dttm(date.toString());
			System.out.println(date.toString());
			System.out.println(man);
			
			try{
				//처음 insert update_tag = 1
				man.setUpdate_tag(updateTAG + 1);
				assemblymanDAO.insert(man);
				
			} catch(Exception e) {
				
//				String manId = man.getAssemblyman_id();
				man.setUpdate_tag(updateTAG + 1);
				int result = assemblymanDAO.update(man);
				
				if(result == 0){
					throw new RuntimeException("insert & update 모두 error!!" + man);
				}
		
			}
		}*/
	}
	
}
