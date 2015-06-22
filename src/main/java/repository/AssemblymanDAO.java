package repository;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import mapper.ManMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.Assemblyman;

@Component
public class AssemblymanDAO {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	//////////////////////////////////////////////////
	

	public int insert(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return insert(man);
	}

	public int update(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return update(man);
	}

	public int selectAssemblyman(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return selectAssemblyman(man);
	}

	public List<Assemblyman> selectList() {
		ManMapper mapper=session.getMapper(ManMapper.class);
		return mapper.selectList();
	}

}
