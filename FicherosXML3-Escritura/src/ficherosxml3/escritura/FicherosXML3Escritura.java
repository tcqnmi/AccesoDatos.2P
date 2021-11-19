
package ficherosxml3.escritura;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class FicherosXML3Escritura {

    
    public static void main(String[] args) {
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        
        try{
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            //Creamos un elemento vivienda
            Element vivienda = doc.createElement("vivienda");
            
            //Añadimos el elemento a nuestro doc como nodo raiz
            doc.appendChild(vivienda);
            
            //Creamos otro elemento persona, le damos un atributo
            //y lo hacemos depender del nodo vivienda
            Element persona1 = doc.createElement("persona");
            persona1.setAttribute("dni","1234567A");
            vivienda.appendChild(persona1);
            //Creamos el elemento nombre, le damos valor y lo hacemos depender de persona
            Element nombre1 = doc.createElement("nombre");
            nombre1.setTextContent("Lucas");
            persona1.appendChild(nombre1);
            
            //Creamos una segunda persona
            Element persona2 = doc.createElement("persona");
            persona2.setAttribute("dni","7654321B");
            vivienda.appendChild(persona2);
            Element nombre2 = doc.createElement("nombre");
            nombre2.setTextContent("Ana");
            persona2.appendChild(nombre2);
            
            //Creaoms el transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //Creamos la fuente
            DOMSource source = new DOMSource(doc);
            
            //Creamos el destino
            StreamResult result = new StreamResult(new FileOutputStream("salida.xml"));
            
            //"empaquetamos" todo para que se cree el xml
            transformer.transform(source,result);
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicherosXML3Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FicherosXML3Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FicherosXML3Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosXML3Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
