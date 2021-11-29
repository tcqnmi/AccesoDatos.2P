/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1718;

/**
 *
 * @author neo
 */
public class Examen171812 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String ficheroSistema = "sol.xml";
        // Creamos un objeto para parsear nuestro sistema solar.
        StarmapSystemParser ssp = new StarmapSystemParser();
        // Asignamos el fichero a nuestro parser.
        ssp.setSystem(ficheroSistema);
        
        // Ahora podemos comenzar a preguntar cosas a nuestro parser.
        System.out.println("El número de planetas en el sistema es "+ssp.getNumberOfPlanets()); // Nos muestra el número de objetos celestiales que son planetas.
        System.out.println("El sistema tiene "+ssp.getNumberOfJumpPoints()+" puntos de salto."); // Nos muestra el número de puntos de salto del sistema
        System.out.println("El sistema tiene "+ssp.getNumberOfSatellites()+" satelites."); // Nos muestra el número de satelites del sistema.
        
        System.out.println("Descripción de Crusader: "+ssp.getPlanetDescription("earth")); // Nos muestra la descripción del planeta Crusader.
        System.out.println("Descripción de microTech: "+ssp.getPlanetDescription("mars")); // Nos muestra la descripción del planeta microTech.

    }
    
}
