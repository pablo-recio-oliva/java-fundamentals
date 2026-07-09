/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

import general.Disparable;
import java.util.UUID;

/**
 *
 * @author recio
 */
public abstract class Arma implements Disparable{
    //Atributos.
    private String identificador;
    private int daño;
    private int diametroBala;
    private Bala[] cargador;
    
    //Constructor parametrizado.
    public Arma(int daño, int diametroBala) {
        this.identificador = generarId();
        this.daño = daño;
        this.diametroBala = diametroBala;
        this.cargador = new Bala [10];
    }

    //Constructor sin parametrizar.
    public Arma() {
        this.identificador = generarId();
        this.daño = 0; 
        this.diametroBala = 0;
        this.cargador = new Bala [10];
    }

    //Setters.
    public void setDaño(int daño) {
        this.daño = daño;
    }

    public void setDiametroBala(int diametroBala) {
        this.diametroBala = diametroBala;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setCargador(Bala[] cargador) {
        this.cargador = cargador;
    }
    
    
    //Getters.
    public String getIdentificador() {
        return identificador;
    }

    public int getDaño() {
        return daño;
    }

    public int getDiametroBala() {
        return diametroBala;
    }

    public Bala[] getCargador() {
        return cargador;
    }
    
    
    //ToString
    public String toString() {
        int numeroBalas = obtenerNumeroBalas();
        return "ID:" + identificador + "\nDaño: " + daño + "\nDiametro bala: " + diametroBala + "\nTamaño del cargador: " + cargador.length + "\nNº balas: " + numeroBalas;
    }
    
    //Método para generar un identificador único para el arma.
    public static String generarId() {
        return UUID.randomUUID().toString();
    }
     
    //Método para mostrar datos.
    public void mostrarDatos(){
        System.out.println("--ARMA--");
        System.out.println("IDENTIFICADOR: "+identificador);
        System.out.println("DAÑO: "+daño);
        System.out.println("DIAMETRO BALA: "+diametroBala);
        
        int balasCargadas = 0;
        for (Bala bala : cargador) {
            if (bala != null) {
                balasCargadas++;
            }
        }
        
        System.out.println("TAMAÑO DEL CARGADOR: "+cargador.length);
        System.out.println("BALAS CARGADAS: "+balasCargadas);
    }
    
    //Método abstracto.
    public abstract void disparar(recursos.personajes.Personaje enemigo);
    
    //Métodos de la interfaz Disparable.
    @Override
    public void apuntar(recursos.personajes.Personaje enemigo){
        if (enemigo==null){
            System.out.println("No hay enemigo al que apuntar");
        }
        else{
            System.out.println("El arma con ID: "+identificador+" está apuntando al enemigo: "+enemigo.getNombre());
            System.out.println("Coordenadas del enemigo: ("+enemigo.getCoordenadaX()+", "+enemigo.getCoordenadaY()+")");
            System.out.println("El daño potencial de este disparo es: "+daño);
        }
        
        if (diametroBala<5){
            System.out.println("Diametro de bala pequeño: "+diametroBala+" mm. El disparo tiene una probabilidad de acierto baja");
        }
        else if (diametroBala<15){
            System.out.println("Diametro de bala normal: "+diametroBala+" mm. El disparo tiene una probabilidad de acierto media");
        }
        else{
            System.out.println("Diametro de bala grande: "+diametroBala+" mm. El disparo sera mas preciso");
        }
    }
    
    /*@Override
    public void cargarArma(){
        System.out.println("Cargando arma...");
    }
    
    @Override
    public int obtenerNumeroBalas(){
        System.out.println("Obteniendo numero de balas...");
        return 0;
    }
    
    @Override
    public void eliminarBala(){
        System.out.println("Eliminando bala del arma...");
    }
    */
    
    //Métodos modificados mision 05
    @Override
    public void cargarArma(){
        for (int i = 0; i < cargador.length; i++) {
            if (cargador[i] == null) {
                cargador[i] = new Bala(diametroBala);
            }
        }
    }
    
    @Override
    public int obtenerNumeroBalas(){
        int count = 0;
        for (Bala bala : cargador) {
            if (bala != null) {
                count++;
            }
        }
        return count;
    }
    
    @Override
    public void eliminarBala(){
        boolean restarBala = false;
        for (int i = cargador.length - 1; i >= 0 && !restarBala; i--) {
            if (cargador[i] != null) {
                cargador[i] = null;
                restarBala=true;
            }
        }
        
        if(restarBala){
            System.out.println("¡Ojo! El cargador está vacío.");
        }
    }
    
}
