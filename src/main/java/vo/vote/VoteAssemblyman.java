package vo.vote;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType (XmlAccessType.FIELD)
public class VoteAssemblyman {
	
	@XmlElement(name = "assemblyman_id")
	private Integer assemblyman_id;
	
	@XmlElementWrapper(name="votes")
	@XmlElement(name = "vote")
	private List<Vote> votes;
	
	/////////////////////////////////////////////////////////////////
	public Integer getAssemblyman_id() {
		return assemblyman_id;
	}

	public void setAssemblyman_id(Integer assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	

}
