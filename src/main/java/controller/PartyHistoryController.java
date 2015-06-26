package controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.PartyService;
import vo.party.PartyHistories;
import vo.party.PartyHistory;


@Controller
public class PartyHistoryController {
	
	private PartyService partyService = new PartyService();
	static PartyHistories partyHistories = new PartyHistories(); 
	
	@Autowired
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}
	

	// saveParty.do
	@RequestMapping(value = "saveParty.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		System.out.println("saveParty.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println(partyHistories);

		for (PartyHistory his : partyHistories.getPartyHistories()) {

			System.out.println(his);
			
			try{
			partyService.insert(his);
			} catch(Exception e) {
				partyService.update(his);
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// updateAssemblyman.do
	/*
	@RequestMapping(value = "updateAssemblyman.do", method = RequestMethod.GET)
	public void updateAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		System.out.println("updateAssemblyman.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println(assemblymen);

		for (Assemblyman man : assemblymen.getAssemblymen()) {

			// mo_dttm 을 update 시간으로 변경
			Date date = new Date();
			man.setMod_dttm(date.toString());
			System.out.println(date.toString());
			System.out.println(man);

			assemblymanService.update(man);
		}
	}
*/
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selecParty.do
	@RequestMapping(value = "selectParty.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int member_seq,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		PartyHistory partyHistory = partyService.selectParty(member_seq);
		System.out.println("member_seq" + member_seq);

		mv.setViewName("viewPartyHistoy");
		mv.addObject("result", partyHistory);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListParty.do
	@RequestMapping(value = "selectListParty.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<PartyHistory> partyHistories = partyService.selectList();
		System.out.println("partyHistories : " + partyHistories);

		mv.setViewName("viewPartyHistoryList");
		mv.addObject("list", partyHistories);
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(PartyHistories.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		PartyHistories hisList = (PartyHistories) jaxbUnmarshaller.unmarshal(file);
		partyHistories = null;
		partyHistories = hisList;
		for (PartyHistory his : hisList.getPartyHistories()) {
			System.out.println(his.getMember_seq());
			System.out.println(his.getParty_name());
		}

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PartyHistories.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(partyHistories, System.out);
		jaxbMarshaller.marshal(partyHistories, new File("c:/temp/assemblymen.xml"));
	}

}
