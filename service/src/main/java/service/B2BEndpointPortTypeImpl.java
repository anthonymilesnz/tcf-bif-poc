package service;

import javax.jws.WebService;
import javax.xml.ws.soap.SOAPFaultException;
import nz.org.tcf.v0_0_1.bif.getversion.B2BEndpointPortType;
import nz.org.tcf.v0_0_1.bif.getversion.GetServiceVersionDetailsRequest;
import nz.org.tcf.v0_0_1.bif.getversion.GetServiceVersionDetailsResponse;


@WebService(targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", portName="B2BEndpointPortType", serviceName="B2BEndpointService", endpointInterface="nz.org.tcf.v0_0_1.bif.getversion.B2BEndpointPortType")

public class B2BEndpointPortTypeImpl implements B2BEndpointPortType {

	private static final String DEFAULT_EXPIRY = "2015-02-09";
	private static final String CUSTOMER_DEFAULT_VERSION = "v1.0";
	private static final String CURRENT_SERVICE_DEFAULT_VERSION = "v2.0";

	public GetServiceVersionDetailsResponse getServiceVersionDetails(GetServiceVersionDetailsRequest getServiceVersionDetailsRequest) throws SOAPFaultException {
		if(getServiceVersionDetailsRequest.getSoapAction().equals("TRIGGER_SAMPLE_FAULT")) {
			throw new TriggeredException("[Triggered SOAP Fault --> Error occurred during processing]");
		}
		GetServiceVersionDetailsResponse getServiceVersionDetailsResponse = new GetServiceVersionDetailsResponse();
		getServiceVersionDetailsResponse.setCurrentServiceVersion(CURRENT_SERVICE_DEFAULT_VERSION);
		getServiceVersionDetailsResponse.setCustomerVersion(CUSTOMER_DEFAULT_VERSION);
		getServiceVersionDetailsResponse.setCustomerVersionExpiry(DEFAULT_EXPIRY);
		getServiceVersionDetailsResponse.setCustomerVersionWorksWithCurrentVersion(Boolean.TRUE);
		getServiceVersionDetailsResponse.setSoapAction(getServiceVersionDetailsRequest.getSoapAction());
		
		return getServiceVersionDetailsResponse;
	}
}

class TriggeredException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	TriggeredException(String message) {
		super(message);
	}
}
