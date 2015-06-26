package vo.vote;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "general_meeting_vote")
@XmlAccessorType (XmlAccessType.FIELD)
public class VoteGeneralMeeting {
	
	@XmlElementWrapper(name = "assemblymen")
	@XmlElement(name = "assemblyman")
	private List<VoteAssemblyman> assemblymen = null;
	////////////////////////////////////////////////////////////////////////////////

	public List<VoteAssemblyman> getAssemblymen() {
		return assemblymen;
	}

	public void setAssemblymen(List<VoteAssemblyman> assemblymen) {
		this.assemblymen = assemblymen;
	}
	

}
