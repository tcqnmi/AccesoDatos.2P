
package examen2021xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;

public class Examen2021xStream {

    
    public static void main(String[] args) {
        
        XStream xstream = new XStream(new DomDriver());
        Class <?>[] clases = new Class[]{Catalogo.class,Disco.class};
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(clases);
        
        xstream.alias("CATALOG", Catalogo.class);
        xstream.alias("CD",Disco.class);
        
        xstream.addImplicitCollection(Catalogo.class, "listaDiscos");
        
        Catalogo listaLectura = new Catalogo();
        File f1 = new File("cd_catalog.xml");
        listaLectura = (Catalogo) xstream.fromXML(f1);
        
        listaLectura.mostrarDiscos();
        
        
    }
    
}
