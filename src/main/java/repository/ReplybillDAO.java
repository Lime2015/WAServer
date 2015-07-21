package repository;

import java.util.List;

import mapper.ReplyMapper;
import mapper.ReplybillMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.reply.Replybill;

@Component
public class ReplybillDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
/////////////////////////////////////////////////////////////////////////

	public int insert(Replybill reply) {
		ReplybillMapper mapper = session.getMapper(ReplybillMapper.class);
		return mapper.insert(reply);
	}

	public int update(Replybill reply) {
		ReplybillMapper mapper = session.getMapper(ReplybillMapper.class);
		return mapper.update(reply);
	}

	public Replybill selectReplybill(int reply_id) {
		ReplybillMapper mapper = session.getMapper(ReplybillMapper.class);
		return mapper.selectReplybill(reply_id);
	}

	public List<Replybill> selectList() {
		ReplybillMapper mapper = session.getMapper(ReplybillMapper.class);
		return mapper.selectList();
	}

}
