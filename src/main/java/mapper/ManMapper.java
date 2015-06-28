package mapper;

import java.util.List;

import vo.Assemblyman;

public interface ManMapper {
	public int insert(Assemblyman man);
	public int update(Assemblyman man);
	public List<Assemblyman> selectList();
	public Assemblyman selectAssemblyman(String manId);

}
