/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import demo.MoveContent;
import demo.Moves;
import demo.ObjectFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLRecord {

    Moves mov;
    JAXBContext context;
    ObjectFactory factory;
    ArrayList<MoveContent> movesContent;
    boolean record = false;

//    public static void main(String[] args) {
//        XMLRecord x = new XMLRecord();
//        x.unmarchal();
//       // x.marchal();
//        x.addMove("ramadan", 1, "x");
//       x.removeLastMove();
//        x.marchal();
//        x.unmarchal();
//    }
    public XMLRecord() {
        factory = new ObjectFactory();
//        movesContent = new ArrayList<>();

    }

    File f = new File("output.xml");

    //      get();
    public void unmarchal() {

        try {
            context = JAXBContext.newInstance("demo");
            Unmarshaller unmarsh = context.createUnmarshaller();

            JAXBElement JAXBPerson = (JAXBElement) unmarsh.unmarshal(f);
            mov = (Moves) JAXBPerson.getValue();

            movesContent = (ArrayList<MoveContent>) mov.getMove();

        } catch (JAXBException ex) {
            Logger.getLogger(XMLRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(XMLRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void marchal() {
        try {

            JAXBElement perso = factory.createGame(mov);
            Marshaller marsheller = context.createMarshaller();
            marsheller.setProperty(marsheller.JAXB_FORMATTED_OUTPUT, true);
            marsheller.marshal(perso, new FileOutputStream(f));
        } catch (JAXBException e) {
            System.err.println("Error in JAXB");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File Not Found");
        }

    }

    public ArrayList<MoveContent> playRecord() {
        return movesContent;
    }

    public void addMove(int position, String draw) {
        if (record == false) {
            movesContent.clear();
            record = true;
        }
        MoveContent move = factory.createMoveContent();
        move.setDraw(draw);

        move.setPosition(position);
        movesContent.add(move);
    }

    public void removeLastMove() {

        movesContent.remove(movesContent.size() - 1);
    }

    private void get() throws JAXBException {

    }
}
