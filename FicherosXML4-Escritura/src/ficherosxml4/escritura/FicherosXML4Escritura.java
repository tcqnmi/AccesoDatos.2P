
package ficherosxml4.escritura;

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


public class FicherosXML4Escritura {

   
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        
        try{
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = docBuilder.newDocument();
            
            Element empresas = doc.createElement("empresas");
            
            doc.appendChild(empresas);
            
            System.out.println("¿Cuántas empresas desea introducir?");
            int num = Integer.parseInt(teclado.nextLine());
            
            for (int i = 0; i < num; i++) {
                
                Element empresa = doc.createElement("empresa");
                
                System.out.println("Nombre de la empresa");
                String nom = teclado.nextLine();
                
                empresa.setAttribute("nombre", nom);
                
                empresas.appendChild(empresa);
                
                System.out.println("¿Cuántos agentes tiene?");
                int numAgentes = Integer.parseInt(teclado.nextLine());
                
                for (int j = 0; j < numAgentes; j++) {
                    Element agente = doc.createElement("agente");
                    empresa.appendChild(agente);
                    
                    System.out.println("Nombre del agente: "+(j+1));
                    String nomAgente = teclado.nextLine();
                    Element nombre = doc.createElement("nombre");
                    nombre.setTextContent(nomAgente);
                    agente.appendChild(nombre);
                    
                    System.out.println("Aepllido del agente: "+(j+1));
                    String apelAgente = teclado.nextLine();
                    Element apellido = doc.createElement("apellido");
                    apellido.setTextContent(apelAgente);
                    agente.appendChild(apellido);
                    
                }
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource source = new DOMSource(doc);
            
            StreamResult result = new StreamResult(new FileOutputStream("empresas.xml"));
            
            transformer.transform(source, result);
        
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicherosXML4Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FicherosXML4Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosXML4Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FicherosXML4Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
