package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.PartyDAO;
import vo.party.PartyHistory;

@Component
public class PartyService {
	
	private PartyDAO partyDAO;
	
	@Autowired
	public void setPartyDAO(PartyDAO partyDAO) {
		this.partyDAO = partyDAO;
	}
	
	////////////////////////////////////////////////////
	public int insert(PartyHistory his) {
		return partyDAO.insert(his);
	}
	public int update(PartyHistory his) {
		return partyDAO.update(his);
	}
	public PartyHistory selectParty(int member_seq) {
		return partyDAO.selectParty(member_seq);
	}
	public List<PartyHistory> selectList() {
		return partyDAO.selectList();
	}
}
