
package examen1718;

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



public class StarmapSystemParser {
    
    private String fichero ;
    
    public void main(){
        
         DocumentBuilderFactory  docFactory = DocumentBuilderFactory.newInstance();
        try {
           
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            File f1 = new File (fichero);
            
            Document doc = docBuilder.parse(fichero);
            
            System.out.println(doc.getNodeName());
            
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void setSystem(String documento){
        this.fichero = documento;
    }
    
    public int getNumberOfPlanets(){
        int cont = 0;
        
         DocumentBuilderFactory  docFactory = DocumentBuilderFactory.newInstance();
            try {
           
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                File f1  = new File (this.fichero);
                Document doc = docBuilder.parse(f1);
                
                NodeList system = doc.getElementsByTagName("system");
                
                for (int i = 0; i < system.getLength() ; i++) {
                    Node nodo = system.item(i);
                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        NodeList hijosSystem = nodo.getChildNodes();
                        for (int l = 0; l < hijosSystem.getLength(); l++) {
                            Node nodo2 = hijosSystem.item(l);
                            if(nodo2.getNodeName().equalsIgnoreCase("data")){
                                NodeList data = nodo2.getChildNodes();
                                for (int j = 0; j < data.getLength(); j++) {
                                    Node nodo3 = data.item(j);
                                    if(nodo3.getNodeType() == Node.ELEMENT_NODE){
                                        if(nodo3.getNodeName().equalsIgnoreCase("resultset")){
                                            NodeList resultset = nodo3.getChildNodes();
                                            for (int m = 0; m < resultset.getLength(); m++) {
                                                Node nodo4 = resultset.item(m);                                              
                                                if(nodo4.getNodeType() == Node.ELEMENT_NODE ){
                                                    if(nodo4.getNodeName().equalsIgnoreCase("celestial_objects")){
                                                        NodeList celestial = nodo4.getChildNodes();
                                                        for (int k = 0; k < celestial.getLength(); k++) {
                                                            Node nodo5 = celestial.item(k);
                                                            if(nodo5.getNodeType() == Node.ELEMENT_NODE){
                                                                if(nodo5.getNodeName().equalsIgnoreCase("type")){
                                                                    
                                                                    Element type = (Element) nodo5;
                                                                    if(type.getTextContent().equalsIgnoreCase("PLANET"))
                                                                        cont++;                                                    

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
                       }
                    }
                    
                }
                
             } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return cont;
    }
    
    public int getNumberOfJumpPoints(){
               
        int cont = 0;
        
        DocumentBuilderFactory  docFactory = DocumentBuilderFactory.newInstance();
            try {
           
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                File f1  = new File (this.fichero);
                Document doc = docBuilder.parse(f1);
                
                NodeList system = doc.getElementsByTagName("system");
                
                for (int i = 0; i < system.getLength() ; i++) {
                    Node nodo = system.item(i);
                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        NodeList hijosSystem = nodo.getChildNodes();
                        for (int l = 0; l < hijosSystem.getLength(); l++) {
                            Node nodo2 = hijosSystem.item(l);
                            if(nodo2.getNodeName().equalsIgnoreCase("data")){
                                NodeList data = nodo2.getChildNodes();
                                for (int j = 0; j < data.getLength(); j++) {
                                    Node nodo3 = data.item(j);
                                    if(nodo3.getNodeType() == Node.ELEMENT_NODE){
                                        if(nodo3.getNodeName().equalsIgnoreCase("resultset")){
                                            NodeList resultset = nodo3.getChildNodes();
                                            for (int m = 0; m < resultset.getLength(); m++) {
                                                Node nodo4 = resultset.item(m);                                              
                                                if(nodo4.getNodeType() == Node.ELEMENT_NODE ){
                                                    if(nodo4.getNodeName().equalsIgnoreCase("celestial_objects")){
                                                        NodeList celestial = nodo4.getChildNodes();
                                                        for (int k = 0; k < celestial.getLength(); k++) {
                                                            Node nodo5 = celestial.item(k);
                                                            if(nodo5.getNodeType() == Node.ELEMENT_NODE){
                                                                if(nodo5.getNodeName().equalsIgnoreCase("type")){
                                                                    Element type = (Element) nodo5;
                                                                    if(type.getTextContent().equalsIgnoreCase("JUMPPOINT"))
                                                                        cont++;                                                    

                                                  

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
                       }
                    }
                    
                }
                
             } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return cont;
    }
    public int getNumberOfSatellites(){
        int cont = 0;
        
        DocumentBuilderFactory  docFactory = DocumentBuilderFactory.newInstance();
            try {
           
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                File f1  = new File (this.fichero);
                Document doc = docBuilder.parse(f1);
                
                NodeList system = doc.getElementsByTagName("system");
                
                for (int i = 0; i < system.getLength() ; i++) {
                    Node nodo = system.item(i);
                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        NodeList hijosSystem = nodo.getChildNodes();
                        for (int l = 0; l < hijosSystem.getLength(); l++) {
                            Node nodo2 = hijosSystem.item(l);
                            if(nodo2.getNodeName().equalsIgnoreCase("data")){
                                NodeList data = nodo2.getChildNodes();
                                for (int j = 0; j < data.getLength(); j++) {
                                    Node nodo3 = data.item(j);
                                    if(nodo3.getNodeType() == Node.ELEMENT_NODE){
                                        if(nodo3.getNodeName().equalsIgnoreCase("resultset")){
                                            NodeList resultset = nodo3.getChildNodes();
                                            for (int m = 0; m < resultset.getLength(); m++) {
                                                Node nodo4 = resultset.item(m);                                              
                                                if(nodo4.getNodeType() == Node.ELEMENT_NODE ){
                                                    if(nodo4.getNodeName().equalsIgnoreCase("celestial_objects")){
                                                        NodeList celestial = nodo4.getChildNodes();
                                                        for (int k = 0; k < celestial.getLength(); k++) {
                                                            Node nodo5 = celestial.item(k);
                                                            if(nodo5.getNodeType() == Node.ELEMENT_NODE){
                                                                if(nodo5.getNodeName().equalsIgnoreCase("type")){
                                                                    Element type = (Element) nodo5;
                                                                    if(type.getTextContent().equalsIgnoreCase("SATELLITE"))
                                                                        cont++;                                                    

                                                  

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
                       }
                    }
                    
                }
                
                
             } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return cont;
    }
    
    
    
    public String getPlanetDescription(String busq){
        String descrip  = "Error";
            DocumentBuilderFactory  docFactory = DocumentBuilderFactory.newInstance();
            try {
           
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                File f1  = new File (this.fichero);
                Document doc = docBuilder.parse(f1);
                
                NodeList system = doc.getElementsByTagName("system");
                
                for (int i = 0; i < system.getLength() ; i++) {
                    Node nodo = system.item(i);
                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        NodeList hijosSystem = nodo.getChildNodes();
                        for (int l = 0; l < hijosSystem.getLength(); l++) {
                            Node nodo2 = hijosSystem.item(l);
                            if(nodo2.getNodeName().equalsIgnoreCase("data")){
                                NodeList data = nodo2.getChildNodes();
                                for (int j = 0; j < data.getLength(); j++) {
                                    Node nodo3 = data.item(j);
                                    if(nodo3.getNodeType() == Node.ELEMENT_NODE){
                                        if(nodo3.getNodeName().equalsIgnoreCase("resultset")){
                                            NodeList resultset = nodo3.getChildNodes();
                                            for (int m = 0; m < resultset.getLength(); m++) {
                                                Node nodo4 = resultset.item(m);                                              
                                                if(nodo4.getNodeType() == Node.ELEMENT_NODE ){
                                                    if(nodo4.getNodeName().equalsIgnoreCase("celestial_objects")){
                                                        NodeList celestial = nodo4.getChildNodes();
                                                        for (int k = 0; k < celestial.getLength(); k++) {
                                                            Node nodo5 = celestial.item(k);
                                                            if(nodo5.getNodeType() == Node.ELEMENT_NODE){
                                                                if(nodo5.getNodeName().equalsIgnoreCase("name")){
                                                                    if(nodo5.getTextContent().equalsIgnoreCase(busq)){
                                                                        for (int n = 0; n < celestial.getLength(); n++) {
                                                                            Node descripcion = celestial.item(n);
                                                                            if(descripcion.getNodeType() == Node.ELEMENT_NODE){
                                                                                if(descripcion.getNodeName().equalsIgnoreCase("description")){
                                                                                   Element elementoDescrip = (Element) descripcion;
                                                                                   descrip = elementoDescrip.getTextContent();
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
                                            

                                        }

                                    }

                                }
                            }
                       }
                    }
                    
                }
                
                
             } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(StarmapSystemParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
        return descrip;
    }    
    
    
    
    
}
