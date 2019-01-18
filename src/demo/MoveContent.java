
package demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveContent", propOrder = {
    "position",
    "draw"
})
public class MoveContent {

    protected int position;
    @XmlElement(required = true)
    protected String draw;

    /**
     * Gets the value of the position property.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Gets the value of the draw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDraw() {
        return draw;
    }

    /**
     * Sets the value of the draw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDraw(String value) {
        this.draw = value;
    }

}
