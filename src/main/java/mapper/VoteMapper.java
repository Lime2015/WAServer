package mapper;

import java.util.List;

import vo.vote.Vote;

public interface VoteMapper {

	public int insert(Vote vote);
	public int update(Vote vote);
	public Vote selectVote(int bill_no);
	public List<Vote> selectList();

}