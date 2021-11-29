
package ficherossax.pkg2.andrea;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.internal.org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class FicherosSAX2Andrea {

    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
         try{
             
            System.out.println("Dime una empresa: ");
            String empresa = teclado.nextLine();
             
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            gestor.setEmpresaABuscar(empresa);
            
            procesadorXML.setContentHandler(gestor);
            
            InputSource fileXML = new InputSource("/Users/andreajimeno/NetBeansProjects/LecturaEmpresaXml/empresas.xml");
            procesadorXML.parse(fileXML);
            
            ArrayList listaAgentes = gestor.getListaAgentes();
            
            System.out.println("Agentes de "+gestor.getEmpresaBuscada()+" : "+listaAgentes.size());
            
            for(int i= 0; i < listaAgentes.size(); i++){
                
                System.out.println(listaAgentes.get(i));
            }
            
        }catch(SAXException e){
            System.out.println(""+e.getMessage());
        }catch(IOException e){
            System.out.println(""+e.getMessage());
        }
    } //fin main
    
    //------
    
    //nueva clase GestionContenido y tiene que extender de DefaultHander
    private static class GestionContenido extends DefaultHandler{
        Scanner teclado = new Scanner(System.in);
       
        boolean empresaNom = false;
        boolean nombreA = false;
        boolean apelA = false;
        
        int cont = 0; //Contar num de agentes
        private String empresa;
        private String agenteActual;
        private ArrayList<String> listaDeAgentes;
        
        
        public GestionContenido() {
            super();
            this.listaDeAgentes = new ArrayList<String>();
        }
        
        private ArrayList getListaAgentes() {
            return this.listaDeAgentes;
        }

        private String getEmpresaBuscada() {
            return this.empresa;
            
        }
        
         private void setEmpresaABuscar(String empresa) {
            this.empresa = empresa;
        }

        @Override
        public void startDocument(){
            //System.out.println("Comenzamos la lectura del documento XML");
        }
        
      
        
        @Override
        public void startElement(String uri, String nombre, String nombreC, Attributes atts){
            
            if (nombre.equals("empresa")) {
                
                if(atts.getValue("nombreEmp").equals(this.empresa)){
                    this.empresaNom = true;
                }
                
                //El nombre de la empresa es un atributo
               
            }   
            if(nombre.equals("agente")){
                this.cont++;
            }
            
            if (nombre.equals("nombre")) {
                        nombreA = true;
                  
            }
            
            if (nombre.equals("apellido")) {
                        apelA = true;
       
            }
  
        }
        
         @Override
        public void endElement(String uri, String nombre, String nombreC){
            if (nombre.equals("empresa")) {
                    this.empresaNom = true;
            }   
            
            if (nombre.equals("nombre")) {
                        nombreA = false;
                  
            }
            
            if (nombre.equals("apellido")) {
                        apelA = false;
       
            }
  
        }
        
        @Override
        public void characters(char[] ch, int inicio, int longitud){
            
            String caracteres = new String(ch, inicio, longitud);
            caracteres = caracteres.replaceAll("[\t\n ]", ""); 
            
            if(!caracteres.isEmpty()){
                
                if(this.empresaNom){
                    
                    if(this.nombreA){
                        this.agenteActual = caracteres;
                    }
                    
                    if(this.apelA){
                        this.agenteActual = this.agenteActual+" "+caracteres;
                        this.listaDeAgentes.add(agenteActual);
                    }
                }
            }
           
        }
        
        @Override
        public void endDocument(){
            //System.out.println("Finalizamos la lectura del documento XML");
        }
       
    }//fin GestionContenido
    }
    
}
