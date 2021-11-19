
package ficherossax.pkg2;

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


public class FicherosSAX2 {

    
    public static void main(String[] args) {
        
        try{
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            
            /* gestor.setEmpresaABuscar(empresa);
            Creamos un metodo que envíe los datos que debemos solicigtar por pantalla
            y enviarlos a la clase gestion de contenido
            */
            
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML = new InputSource("empresas.xml");
            procesadorXML.parse(fileXML);
            
            
            /*Es mejor que la información a solicitar y las impresiones estén en 
            el main, en este caso hacemos un arraylist de datos y ya lo enviamos 
            desde el gestor */
            
        
        } catch (SAXException ex) {
            Logger.getLogger(FicherosSAX2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosSAX2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Creamos la clase que "traducirá" el documento
    public static class GestionContenido extends DefaultHandler{
    
        
        Scanner teclado = new Scanner(System.in);
        
        public boolean esEmpresa;
        public int contAgentes=0;
        public String busqueda; 
        public String aux;
        public boolean encontrada;
        
        //Constructor de la clase llamamos al constructor del padre
        public GestionContenido(){
    
            super();
    
        }
        
        @Override
        public void startDocument(){
        
            System.out.println("¿De qué empresa deseas los agentes?");
            busqueda = teclado.nextLine();
            encontrada = false;
        
        }
        
        @Override
        public void endDocument(){
        
            System.out.println("Hay "+contAgentes+" agentes en total");
        
        }
        
        //Se inicia cada vez que nos encontremos con un < y en nombre le pasa el nombre y en attributes los atributos
        //Uri y nombreC no son necesarios pero hay que ponerlos
        @Override
        public void startElement(String uri, String nombre, String nombreC, Attributes atts){
        
            if(nombre.equals("empresa")){
                /*System.out.printf("\nEmpresa: ");*/
                esEmpresa = true ;
                encontrada = false;
                
            }else if(nombre.equals("agente")){
                if(encontrada){
                    if(esEmpresa){
                        System.out.println("");
                        System.out.printf("\tAgente: \n");
                        //En lugar de escribir por pantalla ponemos un boolean que identifique que estamos leyendo
                    
                    }else{
                        System.out.println("\tAgente: ");
                    }
                    esEmpresa = false;
                }
                contAgentes++;
                
            }else if(nombre.equals("nombre")){
                    if(encontrada){
                        if(!esEmpresa)
                            System.out.printf("\t\tNombre: ");
                    }
                                    
            }else if(nombre.equals("apellido")){
                
                if(encontrada){
                    System.out.printf("\t\tApellido: ");
                }
                
                
            }
        
        }
        
        //Se dispara cuando encuentra >
        @Override
        public void endElement(String uri, String nombre, String nombreC){
        
            //Enviamos el arrayList
            
        }
        
        //Se dispara cuando encuentra con un nodo que no es un elemento, texto
        @Override
        public void characters(char[] ch, int inicio, int longitud){ //pasamos de char{} a String
            
            String caracteres = new String(ch, inicio, longitud);
            caracteres = caracteres.replaceAll("[ \t\n ]", "");//Eliminamos todos los espacios y tabulaciones
            if(!caracteres.isEmpty()){
                
                //Analizamos los boolean que hemos ido poniendo en el código y si es lo que necesitamos lo
                //vamos concatenando y añadiendo al arrayList que al finalizar enviaremos al main y leeremos alli
                
                if(caracteres.equals(busqueda)){
                    if(esEmpresa){
                        encontrada = true;
                        System.out.printf("%s \n",caracteres);
                    }
                    
                }else if(encontrada){
                    
                    System.out.printf("%s \n",caracteres);

                }
            }
        }
        
    
    }
    
}
