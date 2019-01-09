package demo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveContent", propOrder = {
    "playerName",
    "position",
    "draw"
})
public class MoveContent {

    @XmlElement(name = "PlayerName", required = true)
    protected String playerName;
    protected int position;
    @XmlElement(required = true)
    protected String draw;

    public MoveContent(String nesma, String x, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    MoveContent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String value) {
        this.playerName = value;
    }

    public int getPosition() {
        return position;
    }


    public void setPosition(int value) {
        this.position = value;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String value) {
        this.draw = value;
    }

}
