package vo.party;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "party_histories")
@XmlAccessorType (XmlAccessType.FIELD)
public class PartyHistories {

	public PartyHistories() {
		super();
	}
	
	//////////////////////////////////////////////////////////////
	@XmlElement(name = "party_history")
	private List<PartyHistory> partyHistories = null;

	public List<PartyHistory> getPartyHistories() {
		return partyHistories;
	}

	public void setPartyHistories(List<PartyHistory> partyHistories) {
		this.partyHistories = partyHistories;
	}

}
