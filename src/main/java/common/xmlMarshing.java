package common;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import vo.Assemblyman;
import vo.Assemblymen;

public class xmlMarshing {
	static Assemblymen assemblymen = new Assemblymen();

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Assemblymen.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Assemblymen manList = (Assemblymen) jaxbUnmarshaller.unmarshal( new File("c:/temp/assemblymen.xml") );
		
		for(Assemblyman man : manList.getAssemblymen())
		{
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getAssemblyman_name());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Assemblymen.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(assemblymen, System.out);
		jaxbMarshaller.marshal(assemblymen, new File("c:/temp/assemblymen.xml"));
	}


}
