package service;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class OutSoapFaultInterceptor extends AbstractSoapInterceptor {
	
	private static Logger LOG = Logger.getLogger(OutSoapFaultInterceptor.class.getName());
	
	public OutSoapFaultInterceptor() {
		super(Phase.MARSHAL);
	}
	
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		LOG.debug("[processing in OutSoapFaultInterceptor]");
		try {
			buildMessageDiagnosticHeader(soapMessage);
		} catch (Exception exception) {
			LOG.error("[error executing OutSoapFaultInterceptor]");
			LOG.error(exception, exception);
			throw new Fault(exception);
		}
    }
	
	private void buildMessageDiagnosticHeader(SoapMessage soapMessage) throws SOAPException {
		QName qname = new QName("http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", "messageDiagnosticHeader", "mdh");
        SOAPHeaderElement soapHeaderElement = soapMessage.getContent(SOAPMessage.class).getSOAPHeader().addHeaderElement(qname);
        soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
        soapHeaderElement.addChildElement("diagnosticHeaderId").addTextNode(java.util.UUID.randomUUID().toString());
        soapHeaderElement.addChildElement("correlationId").addTextNode((String) soapMessage.getExchange().get("diagnosticHeaderId"));
        soapHeaderElement.addChildElement("createdDateTime").addTextNode(new DateTime().toString());
        soapHeaderElement.addChildElement("toPartyId").addTextNode((String) soapMessage.getExchange().get("fromPartyId"));
        soapHeaderElement.addChildElement("fromPartyId").addTextNode((String) soapMessage.getExchange().get("toPartyId"));
        String uuidSecurityId = java.util.UUID.randomUUID().toString();
        soapHeaderElement.addAttribute(new QName("http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", "URI", "mdh"), "#" + uuidSecurityId);
        soapMessage.getContent(SOAPMessage.class).getSOAPBody().addAttribute(new QName("http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", "Id", "mdh"), uuidSecurityId);
	}
}
