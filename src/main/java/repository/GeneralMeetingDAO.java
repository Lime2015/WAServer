package repository;

import java.util.List;

import mapper.GeneralMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vo.general.GeneralAssemblyman;
import vo.general.GeneralMeeting;
import vo.general.GeneralMeetingAttend;

@Component
public class GeneralMeetingDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//////////////////////////////////////////////////////////////////////////////

	public int insert(GeneralMeeting meeting) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class); 
		return mapper.insert(meeting);
	}
	public int update(GeneralMeeting meeting) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class); 
		return mapper.update(meeting);
	}
	public GeneralMeeting selectGeneralMeeting(Object generalMeeting) {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectGeneralMeeting(generalMeeting);
	}
	public List<GeneralMeeting> selectList() {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectList();
	}

	public int selectUpdate() {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		return mapper.selectUpdate();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void create(int updateTAG, GeneralMeetingAttend generalMeetingAttend) throws Exception {
		GeneralMapper mapper = session.getMapper(GeneralMapper.class);
		
		try{
		for (GeneralAssemblyman man : generalMeetingAttend.getAssemblymen()) {
			
			String assemblyman_id = man.getAssemblyman_id();
			
			for(GeneralMeeting meeting : man.getMettings()){
				
				meeting.setAssemblyman_id(assemblyman_id);
				meeting.setUpdate_tag(updateTAG + 1);
				System.out.println("meeting assembly_id : "+ meeting.getAssemblyman_id());
				System.out.println("updateTAG = " + updateTAG);
				
				try{
					mapper.insert(meeting);
					System.out.println("Inserted into Data Table Successfully"
							+ man.getAssemblyman_id());
					
				} catch(Exception e) {
					int result = mapper.update(meeting);
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
