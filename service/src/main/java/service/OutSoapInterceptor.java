package service;

import java.util.Iterator;

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
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OutSoapInterceptor extends AbstractSoapInterceptor {
	
	private static Logger LOG = Logger.getLogger(OutSoapInterceptor.class.getName());
	
	public OutSoapInterceptor() {
		super(Phase.MARSHAL);
	}
	
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		try {
			SOAPHeader soapHeader = soapMessage.getContent(SOAPMessage.class).getSOAPHeader();
			buildMessageDiagnosticHeader(soapHeader, soapMessage);
			handleHeaders(soapMessage);
		} catch (SOAPException exception) {
			LOG.error("[error executing InSoapInterceptor]");
			LOG.error(exception, exception);
			throw new Fault(exception);
		}
    }
	
	private void buildMessageDiagnosticHeader(SOAPHeader soapHeader, SoapMessage soapMessage) throws SOAPException {
		QName qname = new QName("http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", "messageDiagnosticHeader");
        SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
        soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
        soapHeaderElement.addChildElement("diagnosticHeaderId").addTextNode(java.util.UUID.randomUUID().toString());
        soapHeaderElement.addChildElement("correlationId").addTextNode((String) soapMessage.getExchange().get("diagnosticHeaderId"));
        soapHeaderElement.addChildElement("createdDateTime").addTextNode(new DateTime().toString());
        soapHeaderElement.addChildElement("toPartyId").addTextNode((String) soapMessage.getExchange().get("fromPartyId"));
        soapHeaderElement.addChildElement("fromPartyId").addTextNode((String) soapMessage.getExchange().get("toPartyId"));
	}

	private void handleHeaders(SoapMessage soapMessage) {
		try {
			SOAPHeader soapHeader = soapMessage.getContent(SOAPMessage.class).getSOAPHeader();
			@SuppressWarnings("unchecked")
			Iterator<SOAPHeaderElement> soapHeaderElements = soapHeader.examineAllHeaderElements();
		      while(soapHeaderElements.hasNext()) {
		            javax.xml.soap.SOAPHeaderElement headerElement = (javax.xml.soap.SOAPHeaderElement) soapHeaderElements.next();
		            LOG.debug("[soapHeaderElement]\n" + headerElement.getElementName().getQualifiedName());
		            @SuppressWarnings("unchecked")
					Iterator<Element> childHeaderElements = headerElement.getChildElements();
		            while(childHeaderElements.hasNext()) {
		            	Node node = (Node) childHeaderElements.next();
		            	if(null != node.getLocalName()) {
		            		LOG.debug("[soap header parent node local name]\n" + node.getParentNode().getLocalName());
		            		LOG.debug("[soap header node local name]\n" + node.getLocalName());
		            		LOG.debug("[soap header node text content]\n" + node.getTextContent());
		            	}
		            }
		      }
		} catch (SOAPException exception) {
			LOG.error("[error executing InSoapInterceptor]");
			LOG.error(exception, exception);
			throw new Fault(exception);
		}	
	}
}
