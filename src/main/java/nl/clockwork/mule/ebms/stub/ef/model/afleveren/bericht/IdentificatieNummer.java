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
 * 						Element: identificatieNummer
 * 						Type: Nummer in
 * 						combinatie met het type
 * 						Maximale lengte: 20
 * 
 * 						Normalisatie:
 * 						Mag geen
 * 						enters (#xD of #xA) of tabs (#x9)
 * 						bevatten, indien aanwezig worden
 * 						deze vervangen door spaties. Alle
 * 						dubbele spaties worden vervangen
 * 						door enkele spaties. Spaties aan
 * 						het begin en eind worden
 * 						verwijderd.
 * 
 * 						Beschrijving:
 * 						Is een uniek identieficatie nummer. Bevat
 * 						het nummer plus de
 * 						informatie om aan te geven wat het nummer
 * 						inhoud.
 * 
 * 						De typen die ondersteunt worden zijn:
 * 						BSN, KvK, BTW, Fi en OIN
 * 						
 * 					
 * 
 * <p>Java class for identificatieNummer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identificatieNummer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nummer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="BSN"/>
 *               &lt;enumeration value="KvK"/>
 *               &lt;enumeration value="BTW"/>
 *               &lt;enumeration value="Fi"/>
 *               &lt;enumeration value="OIN"/>
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identificatieNummer", propOrder = {
    "nummer",
    "type"
})
public class IdentificatieNummer {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nummer;
    @XmlElement(required = true, nillable = true)
    protected String type;

    /**
     * Gets the value of the nummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNummer() {
        return nummer;
    }

    /**
     * Sets the value of the nummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNummer(String value) {
        this.nummer = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
