package service;

import java.util.Iterator;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.Text;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class InSoapInterceptor extends AbstractSoapInterceptor {
	
	private static Logger LOG = Logger.getLogger(InSoapInterceptor.class.getName());
	
	public InSoapInterceptor() {
		super(Phase.UNMARSHAL);
	}
	
	public void handleMessage(SoapMessage soapMessage) throws Fault {
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
		            		if(node.getParentNode().getLocalName().equals("messageDiagnosticHeader")) {
		            			if(node.getLocalName().equals("diagnosticHeaderId")) {
		            				LOG.debug("[found 'diagnosticHeader', adding to cxf exchange]");
		            				soapMessage.getExchange().put(node.getLocalName(), node.getTextContent());
		            			}
		            			if(node.getLocalName().equals("fromPartyId")) {
		            				LOG.debug("[found 'fromPartyId', adding to cxf exchange]");
		            				soapMessage.getExchange().put(node.getLocalName(), node.getTextContent());
		            			}
		            			if(node.getLocalName().equals("toPartyId")) {
		            				LOG.debug("[found 'toPartyId', adding to cxf exchange]");
		            				soapMessage.getExchange().put(node.getLocalName(), node.getTextContent());
		            			}
		            		}
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
