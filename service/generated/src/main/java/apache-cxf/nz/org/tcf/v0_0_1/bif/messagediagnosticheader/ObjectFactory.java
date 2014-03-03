
package nz.org.tcf.v0_0_1.bif.messagediagnosticheader;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nz.org.tcf.v0_0_1.bif.messagediagnosticheader package. 
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

    private final static QName _MessageDiagnosticHeader_QNAME = new QName("http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", "MessageDiagnosticHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nz.org.tcf.v0_0_1.bif.messagediagnosticheader
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageDiagnosticHeader }
     * 
     */
    public MessageDiagnosticHeader createMessageDiagnosticHeader() {
        return new MessageDiagnosticHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageDiagnosticHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tcf.org.nz/v0.0.1/bif/MessageDiagnosticHeader", name = "MessageDiagnosticHeader")
    public JAXBElement<MessageDiagnosticHeader> createMessageDiagnosticHeader(MessageDiagnosticHeader value) {
        return new JAXBElement<MessageDiagnosticHeader>(_MessageDiagnosticHeader_QNAME, MessageDiagnosticHeader.class, null, value);
    }

}
