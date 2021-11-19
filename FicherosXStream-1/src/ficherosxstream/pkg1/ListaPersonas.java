
package ficherosxstream.pkg1;

import java.util.ArrayList;


public class ListaPersonas {
    
    ArrayList <Persona> lista = new ArrayList<Persona>();

    public ListaPersonas() {
    }
    
    public void addPersona(Persona p1){
        
        lista.add(p1);
    
    }
    
    public void mostrarTodas(){
    
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Persona nº: "+i);
            System.out.println("\tNombre: "+lista.get(i).getNombre());
            System.out.println("\tApellido: "+lista.get(i).getApellido());
            System.out.println("\tFecha: "+lista.get(i).getFecha());
            System.out.println("\tDni: "+lista.get(i).getDni());
        }
    
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }
    
    
    
}
