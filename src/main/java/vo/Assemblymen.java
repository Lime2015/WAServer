package vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblymen")
@XmlAccessorType (XmlAccessType.FIELD)
public class Assemblymen {
	
	@XmlElement(name = "assemblyman")
	private List<Assemblyman> assemblymanList = null;

	public List<Assemblyman> getAssemblymanList() {
		return assemblymanList;
	}


	public void setAssemblymanList(List<Assemblyman> assemblymanList) {
		this.assemblymanList = assemblymanList;
	}

	

}
