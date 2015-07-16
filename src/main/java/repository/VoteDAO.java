package repository;

import java.util.List;

import mapper.VoteMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vo.vote.Vote;
import vo.vote.VoteAssemblyman;
import vo.vote.VoteGeneralMeeting;

@Component
public class VoteDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(Vote vote) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.insert(vote);
	}
	public int update(Vote vote) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.update(vote);
	}
	public Vote selectVote(Object vote) {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectVote(vote);
	}

	public List<Vote> selectList() {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void create(int updateTAG, VoteGeneralMeeting voteGeneralMeeting) throws Exception {
		VoteMapper mapper = session.getMapper(VoteMapper.class);
		
		try{
		for (VoteAssemblyman man : voteGeneralMeeting.getAssemblymen()) {
			String assemblyman_id = man.getAssemblyman_id();
			
			for(Vote vote : man.getVotes()){
				
				vote.setAssemblyman_id(assemblyman_id);
				vote.setUpdate_tag(updateTAG + 1);
				
				System.out.println("meeting assembly_id : "+ vote.getAssemblyman_id());
				System.out.println("updateTAG = " +  updateTAG);
				
				
				try{
					mapper.insert(vote);
					System.out.println("Inserted into Data Table Successfully"
							+ man.getAssemblyman_id());
					
				} catch(Exception e) {
					int result = mapper.update(vote);
					System.out.println("Update Data Table Successfully" 
							+ man.getAssemblyman_id());
					if (result == 0) {
						throw new RuntimeException("Insert & Update error!!" + man.getAssemblyman_id());
					}
				}
			}
		}
		} catch(Exception e){
			throw e;
		}
		
	}

}
