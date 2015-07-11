package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.VoteDAO;
import vo.vote.Vote;

@Component
public class VoteService {
	
	private VoteDAO voteDAO;
	
	@Autowired
	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	public int insert(Vote vote) {
		return voteDAO.insert(vote);
	}
	public int update(Vote vote) {
		return voteDAO.update(vote);
	}
	public Vote selectVote(Object vote) {
		return voteDAO.selectVote(vote);
	}
	public List<Vote> selectList() {
		return voteDAO.selectList();
	}

	public int selectUpdate() {
		return voteDAO.selectUpdate();
	}

}
