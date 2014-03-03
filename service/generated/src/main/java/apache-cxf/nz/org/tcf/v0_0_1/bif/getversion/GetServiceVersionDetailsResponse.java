
package nz.org.tcf.v0_0_1.bif.getversion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetServiceVersionDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceVersionDetailsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="soapAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentServiceVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerVersionExpiry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerVersionWorksWithCurrentVersion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceVersionDetailsResponse", propOrder = {
    "soapAction",
    "currentServiceVersion",
    "customerVersion",
    "customerVersionExpiry",
    "customerVersionWorksWithCurrentVersion"
})
public class GetServiceVersionDetailsResponse {

    @XmlElement(required = true)
    protected String soapAction;
    @XmlElement(required = true)
    protected String currentServiceVersion;
    @XmlElement(required = true)
    protected String customerVersion;
    @XmlElement(required = true)
    protected String customerVersionExpiry;
    protected boolean customerVersionWorksWithCurrentVersion;

    /**
     * Gets the value of the soapAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapAction() {
        return soapAction;
    }

    /**
     * Sets the value of the soapAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapAction(String value) {
        this.soapAction = value;
    }

    /**
     * Gets the value of the currentServiceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentServiceVersion() {
        return currentServiceVersion;
    }

    /**
     * Sets the value of the currentServiceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentServiceVersion(String value) {
        this.currentServiceVersion = value;
    }

    /**
     * Gets the value of the customerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerVersion() {
        return customerVersion;
    }

    /**
     * Sets the value of the customerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerVersion(String value) {
        this.customerVersion = value;
    }

    /**
     * Gets the value of the customerVersionExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerVersionExpiry() {
        return customerVersionExpiry;
    }

    /**
     * Sets the value of the customerVersionExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerVersionExpiry(String value) {
        this.customerVersionExpiry = value;
    }

    /**
     * Gets the value of the customerVersionWorksWithCurrentVersion property.
     * 
     */
    public boolean isCustomerVersionWorksWithCurrentVersion() {
        return customerVersionWorksWithCurrentVersion;
    }

    /**
     * Sets the value of the customerVersionWorksWithCurrentVersion property.
     * 
     */
    public void setCustomerVersionWorksWithCurrentVersion(boolean value) {
        this.customerVersionWorksWithCurrentVersion = value;
    }

}
