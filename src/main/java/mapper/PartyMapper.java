package mapper;

import java.util.List;

import vo.party.PartyHistory;

public interface PartyMapper {

	public int insert(PartyHistory his);
	public int update(PartyHistory his);
	public PartyHistory selectParty(Object history);
	public List<PartyHistory> selectList();
	public int selectUpdate();

}
