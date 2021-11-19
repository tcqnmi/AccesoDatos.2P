
package ficherosxstream2.serializacion;

import java.util.ArrayList;


public class ListaDeEmpresas {
    
    
    private ArrayList<Empresa> lista = new ArrayList<Empresa>();

    public ListaDeEmpresas() {
    }
    
    public void addEmpresa(Empresa e1){

        lista.add(e1);
    }
    
    public void mostarEmpresas(){
    
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.println("Nombre: "+lista.get(i).getNombre());
            System.out.println("Agentes: ");
            lista.get(i).mostarAgentes();
        }
    }

    public ArrayList<Empresa> getLista() {
        return lista;
    }
    
    
    
}
