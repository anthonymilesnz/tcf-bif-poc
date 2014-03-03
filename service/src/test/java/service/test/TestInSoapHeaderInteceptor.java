package service.test;

import static org.hamcrest.Matchers.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import nz.org.tcf.v0_0_1.bif.getversion.GetServiceVersionDetailsResponse;
import nz.org.tcf.v0_0_1.bif.messagediagnosticheader.MessageDiagnosticHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.test.AbstractCXFTest;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.junit.Test;
import org.xmlsoap.schemas.soap.envelope.EnvelopeDocument;

public class TestInSoapHeaderInteceptor extends AbstractCXFTest {
	
	@Test
	public void TestHandleMessage() throws XMLStreamException, JAXBException, XmlException, IOException {
		MessageDiagnosticHeader messageDiagnosticHeader = new MessageDiagnosticHeader(); 
		messageDiagnosticHeader.setConversationId("928a4d97-cf62-4d19-a251-36742dc03f50");
		messageDiagnosticHeader.setCorrelationId("bb5eb281-2ffc-4061-84dc-608d847fd382");
		messageDiagnosticHeader.setCreatedDateTime("20140220:1959");
		messageDiagnosticHeader.setDiagnosticHeaderId("ddc602ec-eded-4d00-b1e6-286a7f0f1378");
		messageDiagnosticHeader.setSequenceNumber("1000000998");
		messageDiagnosticHeader.setFromPartyId("FROM_RSP");
		messageDiagnosticHeader.setToPartyId("TO_LFC");
		messageDiagnosticHeader.setURI("#Id-123658457462");
		
		ByteArrayOutputStream messageDiagnosticHeaderByteArrayValue = new ByteArrayOutputStream();
		JAXBContext jaxbContext = JAXBContext.newInstance(MessageDiagnosticHeader.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		JAXBElement<MessageDiagnosticHeader> messageDiagnosticHeaderElement = new JAXBElement<MessageDiagnosticHeader>(QName.valueOf("MessageDiagnosticHeader"), MessageDiagnosticHeader.class, messageDiagnosticHeader);
		jaxbMarshaller.marshal(messageDiagnosticHeaderElement, messageDiagnosticHeaderByteArrayValue);
		
		EnvelopeDocument envelopeDocument = EnvelopeDocument.Factory.newInstance();
		envelopeDocument.addNewEnvelope().addNewHeader().set(XmlObject.Factory.parse(messageDiagnosticHeaderByteArrayValue.toString()));
		
		GetServiceVersionDetailsResponse getServiceVersionDetailsResponse = new GetServiceVersionDetailsResponse();
		getServiceVersionDetailsResponse.setCurrentServiceVersion("v2.0");
		getServiceVersionDetailsResponse.setCustomerVersion("v1.0");
		getServiceVersionDetailsResponse.setCustomerVersionExpiry("20150202");
		getServiceVersionDetailsResponse.setCustomerVersionWorksWithCurrentVersion(Boolean.TRUE);
		getServiceVersionDetailsResponse.setSoapAction("QueryPlace");
		
		ByteArrayOutputStream getServiceVersionDetailsResponseByteArrayValue = new ByteArrayOutputStream();
		jaxbContext = JAXBContext.newInstance(GetServiceVersionDetailsResponse.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		JAXBElement<GetServiceVersionDetailsResponse> getServiceVersionDetailsResponseElement = new JAXBElement<GetServiceVersionDetailsResponse>(QName.valueOf("GetServiceVersionDetailsResponse"), GetServiceVersionDetailsResponse.class, getServiceVersionDetailsResponse);
		jaxbMarshaller.marshal(getServiceVersionDetailsResponseElement, getServiceVersionDetailsResponseByteArrayValue);
		
		envelopeDocument.getEnvelope().addNewBody().set(XmlObject.Factory.parse(getServiceVersionDetailsResponseByteArrayValue.toString()));
		System.out.println("envelopeDocument is:\n" + envelopeDocument.toString());
				
		SoapMessage soapMessage = new SoapMessage(new MessageImpl());
		soapMessage.setContent(InputStream.class, new ByteArrayInputStream(envelopeDocument.toString().getBytes()));
		this.handleMessage(soapMessage);
	}
	
	public void handleMessage(SoapMessage soapMessage) throws JAXBException, XmlException, IOException {
		String messageDiagnosticHeaderXpath = "MessageDiagnosticHeader";
		InputStream inputStream = soapMessage.getContent(InputStream.class);
		BufferedInputStream soapMessageInputStream = new java.io.BufferedInputStream(inputStream);
		EnvelopeDocument envelopeDocument = EnvelopeDocument.Factory.parse(soapMessageInputStream);
		System.out.println("soapMessage is:\n" + envelopeDocument.toString());
		soapMessageInputStream.close();
		
		XmlObject[] messageDiagnosticHeaderObject = envelopeDocument.getEnvelope().getHeader().selectPath(messageDiagnosticHeaderXpath);
		System.out.println("[messageDiagnosticHeaderObject is]\n" + messageDiagnosticHeaderObject[0]);
		
		String diagnosticHeaderIdXpath = "MessageDiagnosticHeader/diagnosticHeaderId";
		XmlObject[] diagnosticHeaderIdXmlObject = envelopeDocument.getEnvelope().getHeader().selectPath(diagnosticHeaderIdXpath);
		String diagnosticHeaderId = diagnosticHeaderIdXmlObject[0].getDomNode().getFirstChild().getNodeValue();
		System.out.println("[diagnosticHeaderId is]\n" + diagnosticHeaderId);
		
		String correlationIdXpath = "MessageDiagnosticHeader/correlationId";
		XmlObject[] correlationIdXpathObject = envelopeDocument.getEnvelope().getHeader().selectPath(correlationIdXpath);
		String correlationId = correlationIdXpathObject[0].getDomNode().getFirstChild().getNodeValue();
		System.out.println("[correlationId is]\n" + correlationId);
		
		assertThat(diagnosticHeaderId, is("ddc602ec-eded-4d00-b1e6-286a7f0f1378"));
		assertThat(correlationId, is("bb5eb281-2ffc-4061-84dc-608d847fd382"));
    }
}
