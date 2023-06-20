
package com.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cliente package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _Estimar_QNAME = new QName("http://webservices.com/", "estimar");
    private final static QName _EstimarResponse_QNAME = new QName("http://webservices.com/", "estimarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Estimar }
     * 
     */
    public Estimar createEstimar() {
        return new Estimar();
    }

    /**
     * Create an instance of {@link EstimarResponse }
     * 
     */
    public EstimarResponse createEstimarResponse() {
        return new EstimarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Estimar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Estimar }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.com/", name = "estimar")
    public JAXBElement<Estimar> createEstimar(Estimar value) {
        return new JAXBElement<Estimar>(_Estimar_QNAME, Estimar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstimarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EstimarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices.com/", name = "estimarResponse")
    public JAXBElement<EstimarResponse> createEstimarResponse(EstimarResponse value) {
        return new JAXBElement<EstimarResponse>(_EstimarResponse_QNAME, EstimarResponse.class, null, value);
    }

}
