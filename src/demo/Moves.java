


package demo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moves", propOrder = {
    "move"
})
public class Moves {

    @XmlElement(required = true)
    protected List<MoveContent> move;

    
    public List<MoveContent> getMove() {
        if (move == null) {
            move = new ArrayList<MoveContent>();
        }
        return this.move;
    }

}
