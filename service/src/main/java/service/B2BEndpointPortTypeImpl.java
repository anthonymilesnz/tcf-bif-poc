package service;

import javax.jws.WebService;
import nz.org.tcf.v0_0_1.bif.getversion.B2BEndpointPortType;
import nz.org.tcf.v0_0_1.bif.getversion.GetServiceVersionDetailsRequest;
import nz.org.tcf.v0_0_1.bif.getversion.GetServiceVersionDetailsResponse;
import nz.org.tcf.v0_0_1.bif.messagediagnostic.MessageDiagnostic;

@SuppressWarnings("restriction")
@WebService(targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", portName="B2BEndpointPortType", serviceName="B2BEndpointService", endpointInterface="nz.org.tcf.v0_0_1.bif.getversion.B2BEndpointPortType")

public class B2BEndpointPortTypeImpl implements B2BEndpointPortType {

	private static final String DEFAULT_EXPIRY = "2015-02-09";
	private static final String CUSTOMER_DEFAULT_VERSION = "v1.0";
	private static final String CURRENT_SERVICE_DEFAULT_VERSION = "v2.0";

	public GetServiceVersionDetailsResponse getServiceVersionDetails(GetServiceVersionDetailsRequest parameters) {
		GetServiceVersionDetailsResponse getServiceVersionDetailsResponse = new GetServiceVersionDetailsResponse();
		getServiceVersionDetailsResponse.setCurrentServiceVersion(CURRENT_SERVICE_DEFAULT_VERSION);
		getServiceVersionDetailsResponse.setCustomerVersion(CUSTOMER_DEFAULT_VERSION);
		getServiceVersionDetailsResponse.setCustomerVersionExpiry(DEFAULT_EXPIRY);
		getServiceVersionDetailsResponse.setCustomerVersionWorksWithCurrentVersion(Boolean.TRUE);
		getServiceVersionDetailsResponse.setSoapAction(parameters.getSoapAction());
		
		return getServiceVersionDetailsResponse;
	}
	
	private MessageDiagnostic buildMessageDiagnostic() {
		
		return null;
	}
}
