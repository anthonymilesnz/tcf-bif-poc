
package nz.org.tcf.v0_0_1.bif.getversion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nz.org.tcf.v0_0_1.bif.getversion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetServiceVersionDetailsResponse_QNAME = new QName("http://www.tcf.org.nz/v0.0.1/bif/getVersion", "GetServiceVersionDetailsResponse");
    private final static QName _GetServiceVersionDetailsRequest_QNAME = new QName("http://www.tcf.org.nz/v0.0.1/bif/getVersion", "GetServiceVersionDetailsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nz.org.tcf.v0_0_1.bif.getversion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceVersionDetailsRequest }
     * 
     */
    public GetServiceVersionDetailsRequest createGetServiceVersionDetailsRequest() {
        return new GetServiceVersionDetailsRequest();
    }

    /**
     * Create an instance of {@link GetServiceVersionDetailsResponse }
     * 
     */
    public GetServiceVersionDetailsResponse createGetServiceVersionDetailsResponse() {
        return new GetServiceVersionDetailsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceVersionDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", name = "GetServiceVersionDetailsResponse")
    public JAXBElement<GetServiceVersionDetailsResponse> createGetServiceVersionDetailsResponse(GetServiceVersionDetailsResponse value) {
        return new JAXBElement<GetServiceVersionDetailsResponse>(_GetServiceVersionDetailsResponse_QNAME, GetServiceVersionDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceVersionDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion", name = "GetServiceVersionDetailsRequest")
    public JAXBElement<GetServiceVersionDetailsRequest> createGetServiceVersionDetailsRequest(GetServiceVersionDetailsRequest value) {
        return new JAXBElement<GetServiceVersionDetailsRequest>(_GetServiceVersionDetailsRequest_QNAME, GetServiceVersionDetailsRequest.class, null, value);
    }

}
