
package ficherosxml2.empresa;

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

public class FicherosXML2Empresa {

    
    public static void main(String[] args) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            File f1 = new File("empresas.xml");
            
            Document document = builder.parse(f1);
            
            System.out.println("Elemento raíz: "+document.getDocumentElement().getNodeName());
            
            NodeList empresas = document.getElementsByTagName("empresa");
            
            System.out.println("Número de empresas: "+empresas.getLength());
            
            for (int i = 0; i < empresas.getLength(); i++) {
                Node empresa = empresas.item(i);
                
                if(empresa.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoEmpresa = (Element) empresa;
                    
                    //Imprimir nodeList con .getChildren 
                    
                    NodeList listEmpresa = elementoEmpresa.getChildNodes();
                    System.out.println("");
                    
                    for (int j = 0; j < listEmpresa.getLength(); j++) {
                        
                        Node hijosEmpresa = listEmpresa.item(j);                 
                        
                            if(hijosEmpresa.getNodeType() == Node.ELEMENT_NODE){
                                
                                if(hijosEmpresa.getNodeName() == "nombre"){
                                    
                                    System.out.println("Nombre: "+hijosEmpresa.getTextContent());
                                    //System.out.println("Empresa: "+elementoEmpresa.getElementsByTagName("nombre").item(0).getTextContent());

                                }else{
                                    Element elemEmpleado = (Element) hijosEmpresa;
                                    System.out.println("Agente:"+elemEmpleado.getElementsByTagName("nombre").item(0).getTextContent()+
                                            " "+elemEmpleado.getElementsByTagName("apellido").item(0).getTextContent());
                                }


                            }
                        
                    }
                    /* No se puede hacer así porque puede que no esté en orden  los nodos hijos
                                        
                    System.out.println("");
                    System.out.println("Empresa: "+elementoEmpresa.getElementsByTagName("nombre").item(0).getTextContent());
                    
                    NodeList staff = elementoEmpresa.getElementsByTagName("agente");
                    
                   
                    for (int j = 0; j < staff.getLength(); j++) {
                        
                        Node empleado = staff.item(j);
                        
                        if(empleado.getNodeType() == Node.ELEMENT_NODE){
                        
                            Element elementoEmpleado = (Element) empleado;
                            
                            System.out.println("Empleado : "+elementoEmpleado.getElementsByTagName("nombre").item(0).getTextContent()+
                                    " "+elementoEmpleado.getElementsByTagName("apellido").item(0).getTextContent());
                            
                            
                        }
                        
                    }*/
                }
            }
        
        
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicherosXML2Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FicherosXML2Empresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosXML2Empresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
