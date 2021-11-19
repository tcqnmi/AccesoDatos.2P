
package ficherosxstream.pkg1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FicherosXStream1 {

    
    public static void main(String[] args) {
        
        //Creamos el objeto xStream
        XStream xStreamObj = new XStream(new DomDriver());
        
        //Tenemos que decirle que clases estarán disponibles para el xml
        
        Class<?>[] classes = new Class[] {ListaPersonas.class, Persona.class};
        XStream.setupDefaultSecurity(xStreamObj);
        xStreamObj.allowTypes(classes);
        
        //indicamos la relación entre las etiquetas del XML y nuestras clases.
        xStreamObj.alias("personajes",ListaPersonas.class);
        xStreamObj.alias("personaje",Persona.class);
        
        //Le decimo que no use el termino lista ya que es un valor implicito
        xStreamObj.addImplicitCollection(ListaPersonas.class, "lista");
        
        //Si queremos que una "etiqueta" la transforme en atributo:
        xStreamObj.useAttributeFor(Persona.class,"nombre");
        //si ademas queremos cambiarle de nombre:
        xStreamObj.aliasField("name", Persona.class, "nombre");
        
        //Hasta ahora hemos hecho la configuración del xStream
        //Ahora introducimos los datos deseados
        ListaPersonas listaParaEscribir = new ListaPersonas();
        Persona persona = new Persona ("Tony","Stark",5501,"711117A");
        listaParaEscribir.addPersona(persona);
        persona = new Persona("Wanda","Maximoff",4444,"6553372B");
        listaParaEscribir.addPersona(persona);
        persona = new Persona("Prueba","Persona",6666,"0000000C");
        listaParaEscribir.addPersona(persona);
        
        //Una vez reada la estructura del XML leerlo es muy sencillo:
        
        ListaPersonas lista = new ListaPersonas();
        
        //Más comodo leer directamente de un fichero y no de una cadena en el código
        File ficheroLectura = new File("testLectura.xml");
        
        lista = (ListaPersonas) xStreamObj.fromXML(ficheroLectura);
        //Ahora toda la información del XML estará en nuestro objeto y podremos mostrarla
        
        lista.mostrarTodas();
        
        
        try{
            //Escribimos en el fichero XML el contenido de la lista personas
            xStreamObj.toXML(listaParaEscribir, new FileOutputStream("testEscritura.xml"));
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosXStream1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
