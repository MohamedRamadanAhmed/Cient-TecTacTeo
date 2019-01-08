package view;

import demo.Move;
import demo.MoveContent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlGenerator {
    
    
    
    public static void main(String[] args) {
        get();
    }

  public static void get() {
        try {
                 
            JAXBContext context = JAXBContext.newInstance("demo");
            Unmarshaller unmarsh = context.createUnmarshaller();
            JAXBElement jaxbElement = (JAXBElement) unmarsh.unmarshal(new File("C:\\Users\\Abdelrahman\\Desktop\\Game-Client\\src\\demo.xml"));
            MoveContent content = new MoveContent();
            content.setPosition(0);
            content.setDraw("x");
            content.setPlayerName("Abdo");
            
            
            System.err.println(jaxbElement.getName());
        } catch (JAXBException ex) {
            Logger.getLogger(XmlGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
