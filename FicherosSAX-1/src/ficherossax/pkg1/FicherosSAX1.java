
package ficherossax.pkg1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import org.xml.sax.helpers.DefaultHandler;

public class FicherosSAX1 {

    
    public static void main(String[] args) {
        
        try{
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML = new InputSource("empresas.xml");
            procesadorXML.parse(fileXML);
        
        } catch (SAXException ex) {
            Logger.getLogger(FicherosSAX1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosSAX1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Creamos la clase que "traducirá" el documento
    public static class GestionContenido extends DefaultHandler{
    
        //Constructor de la clase llamamos al constructor del padre
        
        public GestionContenido(){
    
            super();
    
        }
        
        @Override
        public void startDocument(){
        
            System.out.println("Comenzamos la lectura del documento XML");
        
        }
        
        @Override
        public void endDocument(){
        
            System.out.println("Finalizamos la lectura del documento");
        
        }
        
        //Se inicia cada vez que nos encontremos con un < y en nombre le pasa el nombre y en attributes los atributos
        //Uri y nombreC no son necesarios pero hay que ponerlos
        @Override
        public void startElement(String uri, String nombre, String nombreC, Attributes atts){
        
            System.out.println("\tSe ha detectado el elemento: "+nombre);
            if(atts != null){
            
                System.out.println("\tAtributos: "+atts.getValue("nombre"));
            }
        
        }
        
        //Se dispara cuando encuentra >
        @Override
        public void endElement(String uri, String nombre, String nombreC){
        
            System.out.println("\tFin del elemento: "+nombre);
            
        }
        
        //Se dispara cuando encuentra con un nodo que no es un elemento, texto
        @Override
        public void characters(char[] ch, int inicio, int longitud){ //pasamos de char{} a String
            
            String caracteres = new String(ch, inicio, longitud);
            caracteres = caracteres.replaceAll("[ \t\n ]", "");//Eliminamos todos los espacios y tabulaciones
            if(!caracteres.isEmpty()){
            
                System.out.println("\tCaracteres: "+caracteres);
            
            }
        }
        
    
    }
}
    

