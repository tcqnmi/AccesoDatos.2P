
package examen1920;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Examen1920 {

    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            
        
        try {
           
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            File f1 = new File ("smash.xml");
            Document doc = docBuilder.parse(f1);
            
            System.out.println("1.- Mostrar personajes de juego y número de escenarios");
            System.out.println("2.- Mostrar juegos que contienen a un personaje");
            System.out.println("3.- Añadir personaje a juego");
            
            int opc = Integer.parseInt(teclado.nextLine());
            
            switch(opc){
            
                case 1: 
                    
                    System.out.println("Nombre del juego: ");
                    String busq = teclado.nextLine();
                    boolean found = false;
                    
                    NodeList root = doc.getElementsByTagName("root");
                    Node nodoRoot = root.item(0);
                    
                    NodeList games = nodoRoot.getChildNodes();
                    for (int i = 0; i < games.getLength(); i++) {
                        Node nodoGame = games.item(i);
                        System.out.println("Nodo: "+nodoGame.getNodeName());
                        NodeList elements = nodoGame.getChildNodes();
                        for (int j = 0; j < elements.getLength(); j++) {
                            Node elemento = elements.item(j);
                            
                            NodeList interiorElemento = elemento.getChildNodes();
                            for (int k = 0; k < interiorElemento.getLength(); k++) {
                                Node datoJuego = interiorElemento.item(k);
                                
                                if(datoJuego.getNodeType() == Node.ELEMENT_NODE){
                                    if(datoJuego.getNodeName().equalsIgnoreCase("abbreviation")){
                                        if(datoJuego.getTextContent().equalsIgnoreCase(busq)){
                                            for (int l = 0; l < interiorElemento.getLength(); l++) {
                                            Node datos = interiorElemento.item(l);

                                            if(datos.getNodeType() == Node.ELEMENT_NODE){
                                               
                                                if(datos.getNodeName().equalsIgnoreCase("name")){
                                                    
                                                    System.out.println("Nombre: "+datos.getTextContent());  
                                                                                                            
                                                }else if(datos.getNodeName().equalsIgnoreCase("stages")){
                                                    NodeList personajes = datos.getChildNodes();
                                                    System.out.println("Hay "+personajes.getLength()+" escenarios");

                                                }else if(datos.getNodeName().equalsIgnoreCase("characters")){
                                                    NodeList personajes = datos.getChildNodes();
                                                    for (int m = 0; m < personajes.getLength(); m++) {
                                                        Node personaje = personajes.item(m);
                                                        System.out.println(personaje.getTextContent().replaceAll("\\n ",""));  
                                                    }

                                                }
                                            }
                                            }
                                        }
                                        
                                    }
                                
                                }
                            }
                            
                        }
                        
                        
                    }
                    
                    
                    
                    
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
            
            
            }
            
                    
                    
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
