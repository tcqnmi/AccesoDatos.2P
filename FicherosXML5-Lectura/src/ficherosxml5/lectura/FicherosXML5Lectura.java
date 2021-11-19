
package ficherosxml5.lectura;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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


public class FicherosXML5Lectura {

    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        
        try{
        
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            File f1 = new File("empresas.xml");
            
            Document doc = docBuilder.parse(f1); 
            
            
            System.out.println("Nombre del elemento raíz: "+doc.getDocumentElement().getNodeName());
            
            NodeList listaEmpresas = doc.getElementsByTagName("empresa");
            
            leerNodeList(listaEmpresas);
            
       
            System.out.println("¿Qué empresa desea eliminar?");
            String busqEmpresa = teclado.nextLine();
            
            for (int i = 0; i < listaEmpresas.getLength(); i++) {
                Node empresa = listaEmpresas.item(i);
                
                if(empresa.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoEmpresa = (Element) empresa;
                    
                    if(elementoEmpresa.getAttribute("nombre").equals(busqEmpresa)){
                        Node padre = empresa.getParentNode();
                        padre.removeChild(empresa);
                        
                        System.out.println("Nodo de empresa "+busqEmpresa+" eliminado");
                        
                    }
                
                }
            }
            
            leerNodeList(listaEmpresas);
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
            
            Transformer transformer = tFactory.newTransformer();
            
            DOMSource source = new DOMSource(doc);
            
            StreamResult stream = new StreamResult(new FileOutputStream("empresas.xml"));
            
            transformer.transform(source, stream);
            
        
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicherosXML5Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FicherosXML5Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosXML5Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FicherosXML5Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FicherosXML5Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void leerNodeList(NodeList listaEmpresas){
    
        for (int i = 0; i < listaEmpresas.getLength(); i++) {
                Node empresa = listaEmpresas.item(i);
                System.out.println("");
                if(empresa.getNodeType() == Node.ELEMENT_NODE){
                    Element elemEmpresa = (Element) empresa;
                    
                    System.out.println("Nombre de la empresa: "+elemEmpresa.getAttribute("nombre"));
                    NodeList agentes = empresa.getChildNodes();
                    
                    for (int j = 0; j < agentes.getLength(); j++) {
                        Node agente = agentes.item(j);
                        
                        if(agente.getNodeType() == Node.ELEMENT_NODE){
                            Element elemAgente = (Element) agente;
                            
                            System.out.println("Nombre del agente "+(j+1)+": "
                                    +elemAgente.getElementsByTagName("nombre").item(0).getTextContent());
                            System.out.println("Apellido del agente "+(j+1)+": "
                                    +elemAgente.getElementsByTagName("apellido").item(0).getTextContent());

                        
                        }
                    }
                    
                }
                
            }
    
    }
    
}
