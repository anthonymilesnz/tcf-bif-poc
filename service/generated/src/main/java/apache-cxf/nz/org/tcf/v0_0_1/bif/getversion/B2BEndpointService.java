package nz.org.tcf.v0_0_1.bif.getversion;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2014-03-05T20:48:51.547+13:00
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "B2BEndpointService", 
                  wsdlLocation = "classpath:bif-b2b-get-version.wsdl",
                  targetNamespace = "http://www.tcf.org.nz/v0.0.1/bif/getVersion") 
public class B2BEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.tcf.org.nz/v0.0.1/bif/getVersion", "B2BEndpointService");
    public final static QName B2BEndpointPortType = new QName("http://www.tcf.org.nz/v0.0.1/bif/getVersion", "B2BEndpointPortType");
    static {
        URL url = B2BEndpointService.class.getClassLoader().getResource("bif-b2b-get-version.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(B2BEndpointService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:bif-b2b-get-version.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public B2BEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public B2BEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public B2BEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public B2BEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public B2BEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public B2BEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns B2BEndpointPortType
     */
    @WebEndpoint(name = "B2BEndpointPortType")
    public B2BEndpointPortType getB2BEndpointPortType() {
        return super.getPort(B2BEndpointPortType, B2BEndpointPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns B2BEndpointPortType
     */
    @WebEndpoint(name = "B2BEndpointPortType")
    public B2BEndpointPortType getB2BEndpointPortType(WebServiceFeature... features) {
        return super.getPort(B2BEndpointPortType, B2BEndpointPortType.class, features);
    }

}
