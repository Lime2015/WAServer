package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.PartyDAO;
import vo.party.PartyHistories;
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
	public PartyHistory selectParty(Object history) {
		return partyDAO.selectParty(history);
	}
	public List<PartyHistory> selectList() {
		return partyDAO.selectList();
	}

	public int selectUpdate() {
		return partyDAO.selectUpdate();
	}

	public void saveData(int updateTAG, PartyHistories partyHistories) throws Exception {
		partyDAO.create(updateTAG, partyHistories);
		
	}
}
