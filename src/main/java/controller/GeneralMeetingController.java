package controller;

import java.io.File;

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

		// xmlUrl = request.getParameter("xmlUrl");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + generalMeetingAttend);

		for (GeneralAssemblyman man : generalMeetingAttend.getAssemblymen()) {
			
			System.out.println(man);
			Integer assemblyman_id = man.getAssemblyman_id();
//			List<GeneralMeeting> generalMeeting = man.getMettings();
			
			for(GeneralMeeting meeting : man.getMettings()){
				meeting.setAssemblyman_id(assemblyman_id);
				System.out.println("meeting assembly_id : "+ meeting.getAssemblyman_id());
				generalMeetingService.insert(meeting);
				/*try{
					generalMeetingService.insert(meeting);
				} catch(Exception e) {
					generalMeetingService.update(meeting);
				}*/
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
				.marshal(generalMeetingAttend, new File("c:/temp/assemblymen.xml"));
	}


}
