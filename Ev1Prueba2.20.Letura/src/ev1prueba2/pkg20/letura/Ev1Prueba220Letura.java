
package ev1prueba2.pkg20.letura;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class Ev1Prueba220Letura {

    public static void main(String[] args) {
       
        Scanner teclado = new Scanner(System.in);
        
        try{
            
            System.out.println("¿Qué objeto buscas?");
            String busq = teclado.nextLine();
            
            XMLReader procxml =  XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            
            gestor.buscando(busq);
            
            procxml.setContentHandler(gestor);
            
            InputSource file = new InputSource("pokemon.xml");
            
            procxml.parse(file);
            
            String pokemonEncontrado = gestor.devuelvePokemon();
            
            System.out.println("El pokemon que porta "+busq+" es: "+pokemonEncontrado);
            
        
        } catch (SAXException | IOException ex) {
            Logger.getLogger(Ev1Prueba220Letura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static class GestionContenido extends DefaultHandler{
        String busq;
        boolean encontrado = false;
        String pokemon;
        String pokemondef;
        boolean inNombre = false;
        boolean inObjeto = false;
       
        public GestionContenido(){
            super();
            
        }
        @Override
        public void startDocument(){
        
        }
        @Override
        public void endDocument(){}
        
        @Override
        public void startElement(String uri, String nombre, String nombrec, Attributes atts){
        
            if(nombre.equalsIgnoreCase("nombre")){
                inNombre = true;
            }
            if(nombre.equalsIgnoreCase("objeto")){
                inObjeto = true;
            
            }
        
        }
        
        @Override
        public void endElement(String uri, String nombre, String nombrec){
            if(nombre.equalsIgnoreCase("nombre") && !encontrado){
                inNombre = false;
                
                encontrado = false;
            }
            
            if(nombre.equalsIgnoreCase("objeto")){
                inObjeto = false;
            
            }
        }
        
        @Override
        public void characters(char[] ch, int init, int longitud){
        
            String caracteres = new String(ch, init, longitud);
            if(inNombre){
                this.pokemon = caracteres;
            }
    
            if(inObjeto){
                if(caracteres.equalsIgnoreCase(this.busq)){
                    encontrado = true;
                    
                    this.pokemondef = this.pokemon;
                    
                }
            }
            
        }
        
        public void buscando(String busqueda){
            this.busq = busqueda;
        }
        
        public String devuelvePokemon(){
        
            return this.pokemondef;
           
        }
        
        
        
        
    }
    

   
    
}

