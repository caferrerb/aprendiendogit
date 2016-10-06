
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoDocEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoDocEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CEDULA"/>
 *     &lt;enumeration value="TARJETAIDENTIDAD"/>
 *     &lt;enumeration value="PASAPORTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoDocEnum")
@XmlEnum
public enum TipoDocEnum {

    CEDULA,
    TARJETAIDENTIDAD,
    PASAPORTE;

    public String value() {
        return name();
    }

    public static TipoDocEnum fromValue(String v) {
        return valueOf(v);
    }

}
