package nz.org.tcf.v0_0_1.bif.getversion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2014-03-03T22:18:53.372+13:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", name = "B2BEndpointPortType")
@XmlSeeAlso({ObjectFactory.class, nz.org.tcf.v0_0_1.bif.messagediagnosticheader.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface B2BEndpointPortType {

    @WebResult(name = "GetServiceVersionDetailsResponse", targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", partName = "GetServiceVersionDetailsResponse")
    @WebMethod(operationName = "GetServiceVersionDetails", action = "GetServiceVersionDetails")
    public GetServiceVersionDetailsResponse getServiceVersionDetails(
        @WebParam(partName = "GetServiceVersionDetailsRequest", name = "GetServiceVersionDetailsRequest", targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion")
        GetServiceVersionDetailsRequest getServiceVersionDetailsRequest
    );
}
