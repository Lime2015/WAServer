package vo;

import java.util.ArrayList;
import java.util.List;

public class AssemblymanList {
	private String assemblymanListName;
	private List assemblyman = new ArrayList();
	
	public AssemblymanList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/////////////////////////////////////////////////////////////////
	public void addAssemblyman(Assemblyman assemblyman){
		this.assemblyman.add(assemblyman);
	}

	public List getAssemblyman() {
		return assemblyman;
	}
	//////////////////////////////////////////////////////////////////
	
	public String getAssemblymanListName() {
		return assemblymanListName;
	}

	public void setAssemblymanListName(String name) {
		this.assemblymanListName = name;
	}
	

}
