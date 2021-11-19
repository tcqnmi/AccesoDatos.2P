
package ficherosxstream2.serializacion;

import java.util.ArrayList;


public class Empresa {
    
    private String nombre;
    private ArrayList<Agente> lista = new ArrayList<Agente>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Agente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Agente> lista) {
        this.lista = lista;
    }
    
    public void addAgente(Agente a1){
    
        lista.add(a1);
    }
    
    public void mostarAgentes(){
        
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.println("Nombre: "+lista.get(i).getNombre());
            System.out.println("Apellido: "+lista.get(i).getApellido());
            
        }
    }
    
    
}
