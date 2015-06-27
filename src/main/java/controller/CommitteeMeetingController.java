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

		System.out.println("saveCommitteeMeeting.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + committeeMeetingAttend);

		for (CommitteeAssemblyman man : committeeMeetingAttend.getAssemblymen()) {
			
			System.out.println(man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(CommitteeMeeting meeting : man.getMeetings()){
				meeting.setAssemblyman_id(assemblyman_id);
				System.out.println("meeting assembly_id : "+ meeting.getAssemblyman_id());
				
				//committeeMeetingService.insert(meeting);
				try{
					committeeMeetingService.insert(meeting);
				} catch(Exception e) {
					committeeMeetingService.update(meeting);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectAssemblyman.do
/*	@RequestMapping(value = "selectAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int manId,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Assemblyman assemblyman = assemblymanService.selectAssemblyman(manId);
		System.out.println("AssemblymanId" + manId);

		mv.setViewName("viewAssemblyman");
		mv.addObject("result", assemblyman);
		return mv;
	}*/

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListAssemblyman.do
/*	@RequestMapping(value = "selectListAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Assemblyman> assemblymen = assemblymanService.selectList();
		System.out.println("Assemblymen : " + assemblymen);

		mv.setViewName("viewAssemblymanList");
		mv.addObject("list", assemblymen);
		return mv;
	}*/

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(CommitteeMeetingAttend.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CommitteeMeetingAttend assemblymanLsit = (CommitteeMeetingAttend) jaxbUnmarshaller.unmarshal(file);
		committeeMeetingAttend = null;
		committeeMeetingAttend = assemblymanLsit;
		for (CommitteeAssemblyman man : assemblymanLsit.getAssemblymen()) {
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getMeetings());
		}

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CommitteeMeetingAttend.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(committeeMeetingAttend, System.out);
		jaxbMarshaller.marshal(committeeMeetingAttend, new File("c:/temp/assemblymen.xml"));
	}


}
