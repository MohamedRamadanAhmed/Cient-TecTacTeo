/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author hp
 */
public class XMLRecord {
    
      public static void main (String []args)
    {
         XMLRecord x=new  XMLRecord();
        x.set();
    }
    File f= new File("output.xml");
   
  //      get();
    

    
    public void set() {

        try {
            JAXBContext context = JAXBContext.newInstance("demo");
            Unmarshaller unmarsh = context.createUnmarshaller();
         
            JAXBElement JAXBPerson = (JAXBElement) unmarsh.unmarshal(new File("demo.xml"));
            ObjectFactory factory = new ObjectFactory();
            Moves m = factory.createMoves();
            List list = m.getMove();
            list.clear();
            MoveContent content = factory.createMoveContent();
            MoveContent content1 = factory.createMoveContent();
            MoveContent content2 = factory.createMoveContent();

            content.setPosition(0);
            content.setDraw("bhiohio");
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
            marsh.marshal(game, new FileOutputStream(f));
            //System.err.println(jaxbElement.getName());
        } catch (JAXBException ex) {
            Logger.getLogger( XMLRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger( XMLRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void get() throws JAXBException {

       /* JAXBContext context = JAXBContext.newInstance("demo");
        Unmarshaller unmarsh = context.createUnmarshaller();

        JAXBElement jaxbElement = (JAXBElement) unmarsh.unmarshal(f);
        ObjectFactory factory = new ObjectFactory();
        Move m = (Move) jaxbElement.getValue();
        System.out.println(m.getMove().get(0).getPlayerName());
        System.out.println(m.getMove().get(0).getPosition());
        System.out.println(m.getMove().get(0).getDraw());
*/
    } 
}
