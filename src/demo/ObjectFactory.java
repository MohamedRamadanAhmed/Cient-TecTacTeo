


package demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Game_QNAME = new QName("", "game");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Moves }
     * 
     */
    public Moves createMoves() {
        return new Moves();
    }

    /**
     * Create an instance of {@link MoveContent }
     * 
     */
    public MoveContent createMoveContent() {
        return new MoveContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Moves }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "game")
    public JAXBElement<Moves> createGame(Moves value) {
        return new JAXBElement<Moves>(_Game_QNAME, Moves.class, null, value);
    }

}
