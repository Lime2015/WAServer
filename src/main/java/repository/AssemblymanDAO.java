package repository;

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
		return mapper.insert(man);
	}

	public int update(Assemblyman man) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return mapper.update(man);
	}

	public Assemblyman selectAssemblyman(int manId) {
		ManMapper mapper = session.getMapper(ManMapper.class);
		return mapper.selectAssemblyman(manId);
	}

	public List<Assemblyman> selectList() {
		ManMapper mapper=session.getMapper(ManMapper.class);
		return mapper.selectList();
	}

}
