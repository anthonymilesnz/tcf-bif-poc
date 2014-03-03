
package nz.org.tcf.v0_0_1.bif.messagediagnosticheader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageDiagnosticHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageDiagnosticHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diagnosticHeaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conversationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createdDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromPartyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toPartyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageDiagnosticHeader", propOrder = {
    "diagnosticHeaderId",
    "conversationId",
    "correlationId",
    "createdDateTime",
    "fromPartyId",
    "toPartyId"
})
public class MessageDiagnosticHeader {

    @XmlElement(required = true)
    protected String diagnosticHeaderId;
    @XmlElement(required = true)
    protected String conversationId;
    @XmlElement(required = true)
    protected String correlationId;
    @XmlElement(required = true)
    protected String createdDateTime;
    @XmlElement(required = true)
    protected String fromPartyId;
    @XmlElement(required = true)
    protected String toPartyId;
    @XmlAttribute(name = "URI")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "SequenceNumber")
    protected String sequenceNumber;

    /**
     * Gets the value of the diagnosticHeaderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosticHeaderId() {
        return diagnosticHeaderId;
    }

    /**
     * Sets the value of the diagnosticHeaderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosticHeaderId(String value) {
        this.diagnosticHeaderId = value;
    }

    /**
     * Gets the value of the conversationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Sets the value of the conversationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversationId(String value) {
        this.conversationId = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedDateTime(String value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the fromPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromPartyId() {
        return fromPartyId;
    }

    /**
     * Sets the value of the fromPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromPartyId(String value) {
        this.fromPartyId = value;
    }

    /**
     * Gets the value of the toPartyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToPartyId() {
        return toPartyId;
    }

    /**
     * Sets the value of the toPartyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToPartyId(String value) {
        this.toPartyId = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceNumber(String value) {
        this.sequenceNumber = value;
    }

}
