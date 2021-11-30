
package examen2021;

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
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;



public class Examen2021 {

    
    public static void main(String[] args) {
        
        try {
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("¿Qué CD busca?");
            String busq = teclado.nextLine();
            
            XMLReader processXML = XMLReaderFactory.createXMLReader();
            GestorContenido gestor = new GestorContenido(busq);
            InputSource file = new InputSource("cd_catalog.xml");
            processXML.setContentHandler(gestor);
            processXML.parse(file);
            
            
            ArrayList <String> datos = new ArrayList<>();
            datos = gestor.devolver();
            for (int i = 0; i < datos.size(); i++) {
               
                System.out.println(datos.get(i));
            }
            
            
            //Escritura en DOM
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element cd = doc.createElement("CD");
            
            doc.appendChild(cd);
            
            Element title = doc.createElement("TITLE");
            title.setTextContent(datos.get(0));
            cd.appendChild(title);
            
            Element artista = doc.createElement("ARTIST");
            artista.setTextContent(datos.get(1));
            cd.appendChild(artista);
            
            Element pais = doc.createElement("COUNTRY");
            pais.setTextContent(datos.get(2));
            cd.appendChild(pais);
            
            Element empresa = doc.createElement("COMPANY");
            empresa.setTextContent(datos.get(3));
            cd.appendChild(empresa);
            
            Element precio = doc.createElement("PRICE");
            precio.setTextContent(datos.get(4));
            cd.appendChild(precio);
            
            Element anio = doc.createElement("YEAR");
            anio.setTextContent(datos.get(5));
            cd.appendChild(anio);
            
            TransformerFactory tfactory = TransformerFactory.newInstance();
            Transformer trans = tfactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            
            String nombre =""+gestor.devAnio()+".xml";
            
            StreamResult result = new StreamResult(new FileOutputStream (nombre));
           
            trans.transform(source, result);
            
            
            
        } catch (SAXException ex) {
            Logger.getLogger(Examen2021.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen2021.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Examen2021.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Examen2021.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Examen2021.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class GestorContenido extends DefaultHandler {
        
        String busq;
        ArrayList <String> dev = new ArrayList<>();
        boolean inTitle = false;
        boolean encontrado = false;
        boolean inYear=false;
        String anio;
        boolean inArtist =false;
        boolean inCountry =false;
        boolean inCompany =false;
        boolean inPrice =false;
        
        public GestorContenido(String busqueda) {
            super();
            this.busq=busqueda;
        }
        
       
        
        @Override
        public void startDocument(){}
        
        @Override
        public void endDocument(){}
        
        @Override
        public void startElement(String uri, String nombrec, String nombre, Attributes atts){
            
            if(nombrec.equalsIgnoreCase("TITLE")){
                inTitle = true;
            }
            if(nombrec.equalsIgnoreCase("YEAR")){
                inYear=true;
            }
            if(nombrec.equalsIgnoreCase("ARTIST")){
                inArtist = true;
            }
              if(nombrec.equalsIgnoreCase("COUNTRY")){
                inCountry = true;
            }
             
            if(nombrec.equalsIgnoreCase("COMPANY")){
                inCompany = true;
            }
            if(nombrec.equalsIgnoreCase("PRICE")){
                inPrice = true;
            }
           
            
        }
        
        @Override
        public void endElement(String uri, String nombrec, String nomnbre){
        
            if(nombrec.equalsIgnoreCase("TITLE")){
                inTitle = false;
            }
            if(encontrado && nombrec.equalsIgnoreCase("CD")){
                encontrado = false;
            }
            if(nombrec.equalsIgnoreCase("YEAR")){
                inYear=false;
            }
            if(nombrec.equalsIgnoreCase("ARTIST")){
                inArtist = false;
            }
              if(nombrec.equalsIgnoreCase("COUNTRY")){
                inCountry = false;
            }
             
            if(nombrec.equalsIgnoreCase("COMPANY")){
                inCompany = false;
            }
            if(nombrec.equalsIgnoreCase("PRICE")){
                inPrice = false;
            }
             
        }
        
        @Override
        public void characters (char [] ch, int inicio, int longitud){
        
            String caracteres = new String(ch,inicio,longitud);
            caracteres = caracteres.replaceAll(" [\t\n] ","");
            if(inTitle){
                if(caracteres.equalsIgnoreCase(busq)){
                    encontrado = true;
                    dev.add(caracteres.trim());
                }
            }if(encontrado && (inArtist || inCompany || inCountry || inYear || inPrice)){
                dev.add(caracteres.trim());
                if(inYear){
                    this.anio=caracteres;
                }
            }
            
        
        }
        
        public ArrayList devolver(){
            return this.dev;
        }
        
        public String devAnio(){
            return this.anio;
        }
    }
    
}
