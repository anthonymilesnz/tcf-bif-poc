package service;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

public class OutSoapFaultInterceptor extends AbstractSoapInterceptor {
	
	private static Logger LOG = Logger.getLogger(OutSoapFaultInterceptor.class.getName());
	
	public OutSoapFaultInterceptor() {
		super(Phase.PRE_LOGICAL);
	}
	
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		LOG.debug("[processing in OutSoapFaultInterceptor]");
		try {
			soapMessage.getContent(SOAPMessage.class).getSOAPHeader().removeContents();
		} catch (SOAPException exception) {
			LOG.error("[error executing OutSoapFaultInterceptor]");
			LOG.error(exception, exception);
			throw new Fault(exception);
		}
    }
}
