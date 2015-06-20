package vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblymen")
@XmlAccessorType (XmlAccessType.FIELD)
public class Assemblymen {
	
	public Assemblymen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name = "assemblyman")
	private List<Assemblyman> assemblymen = null;

	public List<Assemblyman> getAssemblymen() {
		return assemblymen;
	}

	public void setAssemblymen(List<Assemblyman> assemblymen) {
		this.assemblymen = assemblymen;
	}

}
