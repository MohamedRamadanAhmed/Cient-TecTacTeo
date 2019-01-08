package demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Game_QNAME = new QName("", "game");

    public ObjectFactory() {
    }

    public Move createMove() {
        return new Move();
    }

    public MoveContent createMoveContent() {
        return new MoveContent();
    }

    @XmlElementDecl(namespace = "", name = "game")
    public JAXBElement<Move> createGame(Move value) {
        return new JAXBElement<Move>(_Game_QNAME, Move.class, null, value);
    }

}
