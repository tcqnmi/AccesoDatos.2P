package examen2021xstream;


import java.util.ArrayList;


public class Catalogo {
    
    ArrayList <Disco> listaDiscos = new ArrayList<>();

    public Catalogo() {
    }

    public ArrayList<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(ArrayList<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }
    
    public void anadirDisco(Disco d1){
        listaDiscos.add(d1);
    }
    
    public void mostrarDiscos(){
        for (int i = 0; i < listaDiscos.size(); i++) {
            listaDiscos.get(i).mostrarDisco();
        }
    }
    
}
