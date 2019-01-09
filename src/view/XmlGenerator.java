package view;


import demo.MoveContent;
import demo.Moves;
import demo.ObjectFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlGenerator {

    public static void main(String[] args) throws JAXBException {
        set();

  //      get();
    }

    public static void set() {
        try {
            JAXBContext context = JAXBContext.newInstance("output");
            Unmarshaller unmarsh = context.createUnmarshaller();
         
            JAXBElement JAXBPerson = (JAXBElement) unmarsh.unmarshal(new File("output.xml"));
            ObjectFactory factory = new ObjectFactory();
            Moves m = factory.createMoves();
            List list = m.getMove();
            list.clear();
            MoveContent content = factory.createMoveContent();
            MoveContent content1 = factory.createMoveContent();
            MoveContent content2 = factory.createMoveContent();

            content.setPosition(0);
            content.setDraw("yyyy");
            content.setPlayerName("yy");

            content1.setPosition(1);
            content1.setDraw("o");
            content1.setPlayerName("nesmaa");

            content2.setPosition(2);
            content2.setDraw("x");
            content2.setPlayerName("abdo");

            list.add(content);
            list.add(content1);
            list.add(content2);

            // m.setMove(list);
            JAXBElement game = factory.createGame(m);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marsh.marshal(game, new FileOutputStream("output.xml"));
            //System.err.println(jaxbElement.getName());
        } catch (JAXBException ex) {
            Logger.getLogger(XmlGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void get() throws JAXBException {

       /* JAXBContext context = JAXBContext.newInstance("demo");
        Unmarshaller unmarsh = context.createUnmarshaller();

        JAXBElement jaxbElement = (JAXBElement) unmarsh.unmarshal(new File("output.xml"));
        ObjectFactory factory = new ObjectFactory();
        Move m = (Move) jaxbElement.getValue();
        System.out.println(m.getMove().get(0).getPlayerName());
        System.out.println(m.getMove().get(0).getPosition());
        System.out.println(m.getMove().get(0).getDraw());
*/
    }

}
