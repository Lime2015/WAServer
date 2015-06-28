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

import service.GeneralMeetingService;
import vo.general.GeneralAssemblyman;
import vo.general.GeneralMeeting;
import vo.general.GeneralMeetingAttend;

@Controller
public class GeneralMeetingController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AssemblymanController.class);

	private GeneralMeetingService generalMeetingService;
	static GeneralMeetingAttend generalMeetingAttend = new GeneralMeetingAttend();

	@Autowired
	public void setGeneralMeetingService(GeneralMeetingService generalMeetingService) {
		this.generalMeetingService = generalMeetingService;
	}

	// saveGeneralMeeting.do
	@RequestMapping(value = "saveGeneralMeeting.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		System.out.println("saveGeneralMeeting.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + generalMeetingAttend);

		for (GeneralAssemblyman man : generalMeetingAttend.getAssemblymen()) {
			
			logger.info("man :", man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(GeneralMeeting meeting : man.getMettings()){
				
				//meeting 마다 assemblyman_id 를 추가 입력
				meeting.setAssemblyman_id(assemblyman_id);
				System.out.println("meeting assembly_id : "+ meeting.getAssemblyman_id());
				
				//프라임키 생성
				String general_id = assemblyman_id +"-" +meeting.getMeeting_id();
				System.out.println("general_id : " + general_id);
				meeting.setGeneral_id(general_id);
				
				try{
					System.out.println("insert");
					meeting.setUpdate_tag(1);
					generalMeetingService.insert(meeting);
					
				} catch(Exception e) {
					System.out.println("update");
					
					Integer ver = generalMeetingService.selectGeneralMeeting(general_id).getUpdate_tag();
					
					System.out.println("update ver :" + ver);
					meeting.setUpdate_tag(ver + 1);
					
					generalMeetingService.update(meeting);
				}
				
			}
		}
	}
	
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectGeneralMeeting.do
	@RequestMapping(value = "selectGeneralMeeting.do", method = RequestMethod.GET)
	public ModelAndView selectGeneralMeeting (String general_id,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		GeneralMeeting generalMeeting = generalMeetingService.selectGeneralMeeting(general_id);
		System.out.println("general_id" + general_id);

		mv.setViewName("generalMeeting");
		mv.addObject("result", generalMeeting);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListGeneralMeeting.do
	@RequestMapping(value = "selectListGeneralMeeting.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<GeneralMeeting> generalMeetings = generalMeetingService.selectList();
		System.out.println("generalMeetings : " + generalMeetings);

		mv.setViewName("generalMeetingList");
		mv.addObject("list", generalMeetings);
		
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(GeneralMeetingAttend.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		GeneralMeetingAttend assemblymanLsit = (GeneralMeetingAttend) jaxbUnmarshaller.unmarshal(file);
		generalMeetingAttend = null;
		generalMeetingAttend = assemblymanLsit;
		for (GeneralAssemblyman man : assemblymanLsit.getAssemblymen()) {
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getMettings());
		}

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(GeneralMeetingAttend.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(generalMeetingAttend, System.out);
		jaxbMarshaller
				.marshal(generalMeetingAttend, new File("c:/temp/general_meeting2.xml"));
	}


}
