/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoxstream;

import java.io.Serializable;

/**
 *
 * @author tamar
 */
public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private int fecha;
    private String dni;

    public Persona(String nombre, String apellido, int fecha, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.dni = dni;
        
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public Persona(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
