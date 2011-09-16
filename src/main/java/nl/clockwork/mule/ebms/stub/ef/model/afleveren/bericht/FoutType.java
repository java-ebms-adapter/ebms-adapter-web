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
// Generated on: 2010.11.04 at 09:26:36 PM CET 
//


package nl.clockwork.mule.ebms.stub.ef.model.afleveren.bericht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 						Element: foutType
 * 						Type: Combinatie van foutcode en foutomschrijving
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
 *         &lt;element name="foutCode" type="{http://logius.nl/digipoort/ebms/2.0/afleverservice/1.0/}foutCodeType"/>
 *         &lt;element name="foutBeschrijving" type="{http://logius.nl/digipoort/ebms/2.0/afleverservice/1.0/}foutBeschrijvingType"/>
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
    "foutCode",
    "foutBeschrijving"
})
public class FoutType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutBeschrijving;

    /**
     * Gets the value of the foutCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutCode() {
        return foutCode;
    }

    /**
     * Sets the value of the foutCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutCode(String value) {
        this.foutCode = value;
    }

    /**
     * Gets the value of the foutBeschrijving property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutBeschrijving() {
        return foutBeschrijving;
    }

    /**
     * Sets the value of the foutBeschrijving property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutBeschrijving(String value) {
        this.foutBeschrijving = value;
    }

}
