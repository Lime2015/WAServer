package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.AssemblymanDAO;
import vo.Assemblyman;

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
	
}
