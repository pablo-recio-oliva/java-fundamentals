/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import static operaciones.Menu.jugador;
import recursos.armas.ArmaCortoAlcance;
import recursos.armas.ArmaLargoAlcance;
import recursos.lugares.Almacen;
import recursos.lugares.Comisaria;
import recursos.personajes.Cyborg;
import recursos.personajes.Policia;

/**
 *
 * @author recio
 */
public class Simulacion {
    
    public static void main(String[] args){
        //MISION 6
        Almacen almacen = new Almacen();
        
        almacen.crearArma();
        almacen.crearArma();
        almacen.mostrarArmas();
        almacen.eliminarArma();
        almacen.mostrarArmas();
        
        //MISION 3
        
        /* //Creamos el arma utilizada por el grupo terrorista.
        ArmaCortoAlcance armaLiberacion = new ArmaCortoAlcance(10, 16);
        //Creamos los objetos de tipo Cyborg.
        Cyborg nexus = new Cyborg("Liderazgo", "Francia", "id", "Nexus", 100, 'N', 0, 0, armaLiberacion);
        Cyborg siren = new Cyborg("Logística", "Francia", "id", "Siren", 100, 'N', 0, 0, armaLiberacion);
        //Creamos el arma utilizada por Luna.
        ArmaLargoAlcance armaLuna = new ArmaLargoAlcance(2000.0, 20);
        //Creamos el objeto de tipo Policia.
        Policia lunaCastillo = new Policia(1, "Operaciones", "Largo alcance", "Comisaria", "id", "Luna Castillo", 100, 'L', 0, 0, armaLuna);
        //Le asignamos el objeto de Luna a la variable jugador.
        jugador = lunaCastillo; */
        
        //MISION 4
        
        //Creación de las dos armas de corto alcance
        ArmaCortoAlcance armaLiberacion1 = new ArmaCortoAlcance(10, 12);
        ArmaCortoAlcance armaLiberacion2 = new ArmaCortoAlcance(10, 12);
        
        //Creación de Neexus y Siren
        Cyborg nexus4 = new Cyborg("liderazgo", "Francia", "id", "nexus", 100, 'N', 5, 5, armaLiberacion1);
        Cyborg siren4 = new Cyborg("logistica", "Francia", "id", "siren", 100, 'S', 5, 6, armaLiberacion2);
        
        //Creación de arma de Luna
        ArmaLargoAlcance armaLuna4 = new ArmaLargoAlcance(2000, 20);
        
        //Creación de Luna Castillo
        Policia lunaCastillo4 = new Policia(0, "operaciones", "licencia de armass de largo alcance", "comisaria", "id", "Luna Castillo", 100, 'L', 8, 6, armaLuna4);
        
        //Le asignamos el objeto de Luna a la variable jugador.
        jugador = lunaCastillo4;
        
        /*
        //Nexus apunta con su arma al jugador
        nexus4.getArma().apuntar(jugador);
        
        //Nexus dispara con su arma tres veces al jugador
        for (int i = 0; i < 3; i++){
            nexus4.getArma().disparar(jugador);
        }
        
        //El jugador esquiva los disparos
        for (int i = 0; i < 3; i++){
            jugador.esquivar();
        }
        
        //El jugador se defiende
        jugador.defender();
        
        //Jugador apunta con su arma a Nexus
        jugador.getArma().apuntar(nexus4);
        
        //Jugador dispara con su arma diez veces a Nexus
        for (int i = 0; i < 10; i++){
            jugador.getArma().disparar(nexus4);
        }
        
        //Jugador apunta con su arma a Siren.
        jugador.getArma().apuntar(siren4);
        
        //Jugador dispara con su arma tres veces a Siren
        for (int i = 0; i < 3; i++){
            jugador.getArma().disparar(siren4);
        }
        
        //Siren esquiva los disparos
        for (int i = 0; i < 3; i++){
            siren4.esquivar();
        }
        
        //Siren se defiende
        siren.defender();
        */
        
        //MISION 5
        
        //Nexus ataca al jugador
        nexus4.atacar(jugador);
        
        //El jugador esquiva los disparos.
        jugador.esquivar();
        
        //El jugador se defiende.
        jugador.defender();

        //Jugador ataca 4 veces a Nexus
        for (int i = 0; i < 4; i++) {
            jugador.atacar(nexus4);
        }

        //Jugador ataca 1 vez a Siren
        jugador.atacar(siren4);
        
        //Siren esquiva los disparos
        siren4.esquivar();
        
        //Siren se defiende
        siren4.defender();
       
    }
    
}
