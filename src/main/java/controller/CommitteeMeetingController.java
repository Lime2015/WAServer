package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CommitteeMeetingService;
import vo.committee.CommitteeAssemblyman;
import vo.committee.CommitteeMeeting;
import vo.committee.CommitteeMeetingAttend;

@Controller
public class CommitteeMeetingController {
	private static final Logger logger = LoggerFactory
			.getLogger(AssemblymanController.class);

	private CommitteeMeetingService committeeMeetingService;
	static CommitteeMeetingAttend committeeMeetingAttend = new CommitteeMeetingAttend();
	

	@Autowired
	public void setGeneralMeetingService(CommitteeMeetingService committeeMeetingService) {
		this.committeeMeetingService = committeeMeetingService;
	}

	// saveCommitteeMeeting.do
	@RequestMapping(value = "saveCommitteeMeeting.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {
		
		int updateTAG; //가장 마지막 update_tag 넘버 가져옴 
		
		try{
				updateTAG = committeeMeetingService.selectUpdate();
		} catch(Exception e){
			updateTAG = 0;
		}

		System.out.println("saveCommitteeMeeting.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + committeeMeetingAttend);

		for (CommitteeAssemblyman man : committeeMeetingAttend.getAssemblymen()) {
			
			System.out.println(man);
			String assemblyman_id = man.getAssemblyman_id();
			
			for(CommitteeMeeting meeting : man.getMeetings()){
				meeting.setAssemblyman_id(assemblyman_id);
				
				System.out.println("meeting assembly_id : "+ meeting.getAssemblyman_id());
				System.out.println("updateTAG = " +  updateTAG);
				
				//meeting.setUpdate_tag(updateTAG + 1);
				//committeeMeetingService.insert(meeting);
				try{
					System.out.println("insert");
					meeting.setUpdate_tag(updateTAG + 1);
					committeeMeetingService.insert(meeting);
					
				} catch(Exception e) {
					System.out.println("update");
					
					meeting.setUpdate_tag(updateTAG + 1);
					committeeMeetingService.update(meeting);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectCommitteeMeeting.do
	@RequestMapping(value = "selectCommitteeMeeting.do", method = RequestMethod.GET)
	public ModelAndView selectCommitteeMeeting(Object committeeMeeting	,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		CommitteeMeeting committeeMeeting2 = committeeMeetingService.selectCommitteeMeeting(committeeMeeting);
		//System.out.println("committee_id" + committee_id);

		mv.setViewName("committeeMeeting");
		mv.addObject("result", committeeMeeting2);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListCommitteeMeeting.do
	@RequestMapping(value = "selectListCommitteeMeeting.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<CommitteeMeeting> committeeMeetings = committeeMeetingService.selectList();
		System.out.println("committeeMeetings : " + committeeMeetings);

		mv.setViewName("committeeMeetingList");
		mv.addObject("list", committeeMeetings);
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(CommitteeMeetingAttend.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CommitteeMeetingAttend assemblymanLsit = (CommitteeMeetingAttend) jaxbUnmarshaller.unmarshal(file);
		committeeMeetingAttend = null;
		committeeMeetingAttend = assemblymanLsit;
		/*for (CommitteeAssemblyman man : assemblymanLsit.getAssemblymen()) {
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getMeetings());
		}*/

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CommitteeMeetingAttend.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(committeeMeetingAttend, System.out);
		jaxbMarshaller.marshal(committeeMeetingAttend, new File("c:/temp/assemblymen2.xml"));
	}


}
