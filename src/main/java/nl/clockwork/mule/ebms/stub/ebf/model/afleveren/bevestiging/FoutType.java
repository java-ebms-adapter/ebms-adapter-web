/*******************************************************************************
 * Copyright 2011 Clockwork
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.11 at 02:17:44 PM CEST 
//


package nl.clockwork.mule.ebms.stub.ebf.model.afleveren.bevestiging;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 						Element				:	foutType
 * 						Type						:	Combinatie van foutcode en foutomschrijving.
 * 					
 * 
 * <p>Java class for foutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foutcode" type="{http://logius.nl/digipoort/ebms/2.0/afleverservice/1.1/}foutcodeType"/>
 *         &lt;element name="foutbeschrijving" type="{http://logius.nl/digipoort/ebms/2.0/afleverservice/1.1/}foutbeschrijvingType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foutType", propOrder = {
    "foutcode",
    "foutbeschrijving"
})
public class FoutType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutcode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutbeschrijving;

    /**
     * Gets the value of the foutcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutcode() {
        return foutcode;
    }

    /**
     * Sets the value of the foutcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutcode(String value) {
        this.foutcode = value;
    }

    /**
     * Gets the value of the foutbeschrijving property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutbeschrijving() {
        return foutbeschrijving;
    }

    /**
     * Sets the value of the foutbeschrijving property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutbeschrijving(String value) {
        this.foutbeschrijving = value;
    }

}
