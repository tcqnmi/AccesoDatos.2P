
package repasoxstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RepasoXstream {

    public static void main(String[] args) {
        /* ESCRITURA
        try { 
            XStream xstream = new XStream(new DomDriver ());
            
            Class <?>[] clases = new Class[]{ListaPersonas.class, Persona.class};
            
            XStream.setupDefaultSecurity(xstream);
            
            xstream.allowTypes(clases);
            
            xstream.alias("Personas",ListaPersonas.class);
            xstream.alias("Persona", Persona.class);
            
            xstream.addImplicitCollection(ListaPersonas.class, "lista");
            
            ListaPersonas listaEscritura = new ListaPersonas();
            
            Persona p1 = new Persona("juan","lopez",65,"20-05");
            listaEscritura.addPersona(p1);
            
            xstream.toXML(listaEscritura, new FileOutputStream("personasRepaso.xml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepasoXstream.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
        XStream xstream = new XStream(new DomDriver());
        Class <?> [] clases = new Class[]{ListaPersonas.class,Persona.class};
        
        XStream.setupDefaultSecurity(xstream);
        
        xstream.allowTypes(clases);
        
        xstream.alias("Personas", ListaPersonas.class);
        xstream.alias("Persona",Persona.class);
        
        xstream.addImplicitCollection(ListaPersonas.class, "lista");
        
        ListaPersonas listalectura = new ListaPersonas();
        File f1 = new File ("personasRepaso.xml");
        listalectura =(ListaPersonas) xstream.fromXML(f1);
        listalectura.mostrarTodas();
        
    }
    
}
