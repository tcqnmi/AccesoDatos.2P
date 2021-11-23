
package ficherosxstream2.serializacion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FicherosXStream2Serializacion {

    
    public static void main(String[] args) {
        
        
        XStream xStream = new XStream(new DomDriver());
        
        Class<?>[] classes = new Class[]{ListaDeEmpresas.class, Empresa.class, Agente.class};
        
        //Eliminamos los errores de seguridad de la clase XStream
        XStream.setupDefaultSecurity(xStream);
        //"Permitimos el array de clases para la traducción"
        xStream.allowTypes(classes);
        
        //Damos el nombre de etiqueta que tendrá cada clase
        xStream.alias("Empresas", ListaDeEmpresas.class);
        xStream.alias("Empresa", Empresa.class);
        xStream.alias("Agente", Agente.class);
        
        xStream.addImplicitCollection(ListaDeEmpresas.class, "lista");
        xStream.addImplicitCollection(Empresa.class, "lista");
        
        // xStream.toXML(listaEscribir, new FileOutputStream("empresa.xml"));
        
        ListaDeEmpresas listaLectura = new ListaDeEmpresas();
        File fichLectura = new File("empresa.xml");
        listaLectura = (ListaDeEmpresas) xStream.fromXML(fichLectura);
        listaLectura.mostarEmpresas();
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("¿Qué desea hacer?");
        System.out.println("1.- Mosrtar los agentes de una empresa");
        System.out.println("2.- Añadir un agente a una empresa");
        int opc = Integer.parseInt(teclado.nextLine());
        
        switch(opc){
        
            case 1:
                System.out.println("¿Qué empresa buscas?");
                String busq = teclado.nextLine();
                boolean empEncontrada = false;
                
                for (int i = 0; i <listaLectura.getLista().size(); i++) {
                    if(busq.equalsIgnoreCase(listaLectura.getLista().get(i).getNombre())){
                        listaLectura.getLista().get(i).mostarAgentes();   
                        empEncontrada= true;
                        break;
                    }
                }
                if(!empEncontrada){
                    System.out.println("Empresa no encontrada");
                }
                
                break;
                
            case 2:
                System.out.println("¿A qué empresa deseas añadirlo?");
                busq = teclado.nextLine();
                empEncontrada = false;
                
                for (int i = 0; i <listaLectura.getLista().size(); i++) {
                    if(busq.equalsIgnoreCase(listaLectura.getLista().get(i).getNombre())){
                        
                        empEncontrada = true; 
                        
                        System.out.println("Nombre del agente: ");
                        String nom = teclado.nextLine();
                
                        System.out.println("Apellido del agente: ");
                        String apel = teclado.nextLine();
                        Agente a1 = new Agente(nom,apel);
                        
                        try {
                            listaLectura.getLista().get(i).addAgente(a1);
                            xStream.toXML(listaLectura, new FileOutputStream("empresa.xml"));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FicherosXStream2Serializacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                if(!empEncontrada){
                    System.out.println("Empresa no encontrada");
                }
        
        }
        
        
        
    }
    
}
