/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.personajes;
import general.Jugable;
import recursos.armas.Arma;
import recursos.armas.ArmaCortoAlcance;
/**
 *
 * @author recio
 */
public class Cyborg extends Personaje implements Jugable{
    //Atributos.
    private String habilidad;
    private String paisOrigen;
    
    //Constructor parametrizado.
    public Cyborg(String habilidad, String paisOrigen, String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, Arma arma) {
        super(identificador, nombre, vida, marca, coordenadaX, coordenadaY, arma);
        this.habilidad = habilidad;
        this.paisOrigen = paisOrigen;
    }
    
    //Constructor sin parametrizar.
    public Cyborg() {
        super(Personaje.generarId(), "", 100, 'x', 0, 0, new ArmaCortoAlcance());
        this.habilidad = "";
        this.paisOrigen = "";
    }
    
    //Setters.
    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    //Getters.
    public String getHabilidad() {
        return habilidad;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    //Método para mostrar datos.
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("HABILIDAD: "+habilidad);
        System.out.println("PAIS ORIGEN: "+paisOrigen);
    }
    
    //Métodos de la interfaz Jugable
    /*@Override
    public void atacar(Personaje enemigo) {
        System.out.println("Cyborg atacando...");
    }
    */
    @Override
    public void esquivar() {
        int coordenadaActual = getCoordenadaY();
        int movimientoAleatorio = (int) ((Math.random()*3) -1);
        if (movimientoAleatorio != 0){
            int coordenadaYnew = getCoordenadaY() + movimientoAleatorio;
            System.out.println("Cyborg: "+getNombre()+" se mueve en Y de "+coordenadaActual+" a "+coordenadaYnew);
        }
        else{
            System.out.println("Cyborg: "+getNombre()+" mantiene su posicion en Y");
        }
    }

    @Override
    public void defender() {
        int escudoAleatorio = (int) (Math.random()*(30 - 10 + 1)+10);
        if (getVida() + escudoAleatorio <= 100){
            setVida(escudoAleatorio+getVida());
        }
        else{
            setVida(100);
        }
        System.out.println("Cyborg: "+getNombre()+" crea escudo de "+escudoAleatorio+" | Vida: "+getVida());
    }
    
    //Metodo atacar modificado mision 05
    @Override
    public void atacar(Personaje enemigo) {
        if (enemigo.getVida() <= 0) {
            System.out.println("El enemigo ya está abatido.");
        } else {
            System.out.println("Cyborg: " + getNombre() + " se prepara para atacar.");
            if (getArma() == null) {
                System.out.println("Cyborg: " + getNombre() + " no tiene arma asignada.");
            } else {
                if (getArma().obtenerNumeroBalas() == 0) {
                    System.out.println("El arma del cyborg: " + getNombre() + " está vacía.");
                    getArma().cargarArma();
                }
                getArma().apuntar(enemigo);
                getArma().disparar(enemigo);
                getArma().eliminarBala();
                
            }
        }
    }

}
