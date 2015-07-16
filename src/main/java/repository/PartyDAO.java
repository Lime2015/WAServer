package repository;

import java.util.List;

import mapper.PartyMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import controller.AssemblymanController;
import vo.party.PartyHistories;
import vo.party.PartyHistory;

@Component
public class PartyDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(PartyDAO.class);
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////

	public int insert(PartyHistory his) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.insert(his);
	}

	public int update(PartyHistory his) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.update(his);
	}

	public PartyHistory selectParty(Object history) {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectParty(history);
	}

	public List<PartyHistory> selectList() {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		PartyMapper mapper = session.getMapper(PartyMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void create(int updateTAG, PartyHistories partyHistories) throws Exception {
		logger.info("partyHistories", partyHistories);

		try {
			PartyMapper mapper = session.getMapper(PartyMapper.class);
			for (PartyHistory his : partyHistories.getPartyHistories()) {
				his.setUpdate_tag(updateTAG + 1);

				try {
					System.out.println(his);
					mapper.insert(his);
					System.out.println("Inserted into Date Table Successfully" 	+ his.getParty_name());

				} catch (Exception e) {
					int result = mapper.update(his);
					System.out.println("Update Date Table Successfully" + his.getParty_name());
					
					if(result == 0){ 
						throw new RuntimeException("Insert & Update error!!" + his.getParty_name());
						}
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

}
