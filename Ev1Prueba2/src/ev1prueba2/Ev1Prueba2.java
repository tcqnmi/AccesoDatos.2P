
package ev1prueba2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


public class Ev1Prueba2 {

    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document doc = builder.newDocument();
            
            Element entrenador = doc.createElement("entrenador");
            entrenador.setAttribute("nombre", "green");
            doc.appendChild(entrenador);
            
            
            System.out.println("¿Cuantos pokemon desea añadir?");
            int numPokemon = Integer.parseInt(teclado.nextLine());
            
            for (int i = 0; i < numPokemon; i++) {
                Element pokemon = doc.createElement("pokemon");
                entrenador.appendChild(pokemon);
            
                System.out.println("Nombre del pokemon: ");
                String nom = teclado.nextLine();
                
                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(nom);
                pokemon.appendChild(nombre);
                
                System.out.println("Nombre del objeto: ");
                String obj = teclado.nextLine();
                
                 Element objeto = doc.createElement("objeto");
                objeto.setTextContent(obj);
                pokemon.appendChild(objeto);
            }
            
          
            TransformerFactory tfactory = TransformerFactory.newInstance();
            Transformer trans = tfactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream("pokemon.xml"));
            trans.transform(source, result);
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Ev1Prueba2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Ev1Prueba2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ev1Prueba2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Ev1Prueba2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
