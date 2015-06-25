package vo.bill;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bill_info")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillInfo {

	@XmlElementWrapper(name = "assemblymen")
	@XmlElement(name = "assemblyman")
	private List<BillAssemblyman> assemblymen = null;
	
	///////////////////////////////////////////////////////////////////////////////
	public List<BillAssemblyman> getAssemblymen() {
		return assemblymen;
	}

	public void setAssemblymen(List<BillAssemblyman> assemblymen) {
		this.assemblymen = assemblymen;
	}
}
