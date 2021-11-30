
package repasosax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class RepasoSAX {

    
    public static void main(String[] args) {
        
        try {
            XMLReader procxml = XMLReaderFactory.createXMLReader();
            GestorContenido gestor = new GestorContenido();
            InputSource fileXML = new InputSource("smash.xml");
            procxml.parse(fileXML);
                   
            
            
            
        } catch (SAXException ex) {
            Logger.getLogger(RepasoSAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepasoSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    private static class GestorContenido extends DefaultHandler {

        public GestorContenido() {
            super();
        }
        @Override
        public void startDocument(){}
        @Override
        public void endDocument(){}
        @Override
        public void startElement(String uri, String nombre, String nombrec, Attributes atts){
        
        }
        @Override
        public void endElement(String uri, String nombre, String nombrec){}
        @Override
        public void characters(char[] ch, int inicio, int longitud){
            String caracteres = new String(ch, inicio, longitud);
                    
        }
        
    }
    
   

   
}


