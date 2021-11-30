
package examen1920;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
                    
                    Node abreviatura = doc.getElementsByTagName("abbreviation").item(0);
                    if(abreviatura.getTextContent().equalsIgnoreCase(busq)){
                        
                        Node padre = abreviatura.getParentNode();
                        Element elementoPadre = (Element) padre;
                       
                        NodeList juego = padre.getChildNodes();
                        
                        for (int i = 0; i < juego.getLength(); i++) {
                            if(juego.item(i).getNodeName().equalsIgnoreCase("name")){
                                System.out.println(juego.item(i).getTextContent());
                            }else if(juego.item(i).getNodeName().equalsIgnoreCase("characters")){
                                NodeList elementosCaracteres = juego.item(i).getChildNodes();
                                for (int j = 0; j < elementosCaracteres.getLength(); j++) {
                                    System.out.println(elementosCaracteres.item(j).getTextContent().replaceAll("[ \t\n ]", ""));
                                }
                            }else if(juego.item(i).getNodeName().equalsIgnoreCase("stages")){
                                NodeList elementosCaracteres = juego.item(i).getChildNodes();
                                int cont = 0;
                                for (int j = 0; j < elementosCaracteres.getLength(); j++) {
                                    cont++;
                                }
                                System.out.println("Hay "+cont+" escenarios" );
                            }   
                        }
                        
                    
                    }
                    
                    /*boolean found = false;
                    
                    NodeList root = doc.getElementsByTagName("root");
                    Node nodoRoot = root.item(0);
                    
                    NodeList games = nodoRoot.getChildNodes();
                    for (int i = 0; i < games.getLength(); i++) {
                        Node nodoGame = games.item(i);
                        
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
                        
                        
                    }*/
                    
                    break;
                    
                case 2:
                    ArrayList <String> listaJuegos = new ArrayList<>();
                    
                    System.out.println("Nombre del personaje: ");
                    String personajeBusq = teclado.nextLine();
                   
                    NodeList characters2 = doc.getElementsByTagName("characters");
                    
                    for (int i = 0; i < characters2.getLength(); i++) {
                        Node elementoPersonaje = characters2.item(i);
                        
                        NodeList elements = elementoPersonaje.getChildNodes();
                        for (int j = 0; j < elements.getLength(); j++) {
                            Node element = elements.item(j);
                            NodeList names = element.getChildNodes();
                            for (int k = 0; k < names.getLength(); k++) {
                                Node name = names.item(k);
                               
                                if(name.getTextContent().replaceAll("[\n\t]","").equalsIgnoreCase(personajeBusq)){
                                    Node elementosJuegos = elementoPersonaje.getParentNode();
                                    NodeList elementojuego = elementosJuegos.getChildNodes();
                                    for (int l = 0; l < elementojuego.getLength(); l++) {
                                        Node nombreJuego = elementojuego.item(l);
                                        if(nombreJuego.getNodeName().equalsIgnoreCase("name")){
                                            String juego ;
                                            juego = nombreJuego.getTextContent();
                                           
                                            listaJuegos.add(juego);
                                        }
                                    }        
                                   
                                }
                            }
                        }
                       
                        
                    }
                    System.out.println(listaJuegos.size());
                    for (int i = 0; i < listaJuegos.size(); i++) {
                        System.out.println(listaJuegos.get(i));
                    }
                    
                    
                    
                    break;
                    
                case 3:
                    System.out.println("¿A qué juego añadiremos el personaje?");
                    String busqJuego = teclado.nextLine();
                    
                    System.out.println("Nuevo personaje: ");
                    String nuevoPersonaje = teclado.nextLine();
                    
                    if(doc.getElementsByTagName("abbreviation").item(0).getTextContent().equalsIgnoreCase(busqJuego)){
                        System.out.println(doc.getElementsByTagName("abbreviation").item(0).getTextContent());
                        
                        Node anadirPersonaje = doc.getElementsByTagName("characters").item(0);
                        Element elemento = doc.createElement("element");
                        anadirPersonaje.appendChild(elemento);
                        Element nombre = doc.createElement("name");
                        nombre.setTextContent(nuevoPersonaje);
                        elemento.appendChild(nombre);
                        
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new FileOutputStream("smash.xml"));
                        transformer.transform(source,result);
                    }
                    
                    break;
            
            
            }
            
                    
                    
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Examen1920.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
