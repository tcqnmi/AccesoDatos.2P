
package ficherosxml1.pkg1;

import java.io.File;
import java.io.IOException;
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


public class FicherosXML11 {

    public static void main(String[] args) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            File fichero = new File("personajes.xml");
            
            Document document = builder.parse(fichero);
            
            //Imprimos el elemento raiz del xml sacando el nomnbre del primer elemento
            System.out.println("Elemento raiz: "+document.getDocumentElement().getNodeName());
            
            //Creamos una lista con todos los nodos de las personas
            NodeList personajes = document.getElementsByTagName("persona");
            
            //sacamos el número de elementos persona que hay en el fichero
            System.out.println("Número de elementos: "+personajes.getLength());
            
            //Recorremos la lista
            for (int i = 0; i < personajes.getLength(); i++) {
                
                //almacenamos en un objeto de tipo node cada persona
                Node personaje = personajes.item(i);
                //comprobamos que en ese nodo haya un elemento
                if(personaje.getNodeType()== Node.ELEMENT_NODE){
                    Element elemento = (Element) personaje;
                    
                    //getElementsByTagNAme nos devuelve un nodelist con todos los nodos que se llamen id en ese elemento
                    // con item(posicion) sacamos el contenido de cada uno, getTextContent nos saca la info
                    //System.out.println("ID: "+elemento.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Nombre: "+elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Apellido: "+elemento.getElementsByTagName("apellido").item(0).getTextContent());
                    
                    //MODIFICACIÖN:
                    //Ponemos el id como atributo en lugar de como elemento de modo que tenemos que acceder
                    //mediante getAttribute del elemento
                    System.out.println("ID: "+elemento.getAttribute("id"));
                }
                
            }
        
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicherosXML11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FicherosXML11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosXML11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
