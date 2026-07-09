/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.personajes;
import java.util.UUID;
import recursos.armas.Arma;
import recursos.armas.ArmaCortoAlcance;
/**
 *
 * @author recio
 */
public class Personaje {
    //Atributos.
    private String identificador;
    private String nombre;
    private int vida;
    private char marca;
    private int coordenadaX;
    private int coordenadaY;
    private Arma arma;
    
    //Constructor parametrizado.
    public Personaje(String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, Arma arma) {
        this.identificador = generarId();
        this.nombre = nombre;
        this.vida = 100;
        this.marca = marca;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.arma = new ArmaCortoAlcance();
    }

    public Personaje(String nombre, char marca, int coordenadaX, int coordenadaY, Arma arma) {
        this.identificador = generarId();
        this.nombre = nombre;
        this.vida = 100;
        this.nombre = nombre;
        this.marca = marca;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.arma = new ArmaCortoAlcance();
    }
    
    
    //Constructor sin parametrizar.
    public Personaje() {
    this.identificador = generarId();
    this.nombre = "";
    this.vida = 100;
    this.marca = 'x';
    this.coordenadaX = 0;
    this.coordenadaY = 0;
    this.arma = new ArmaCortoAlcance();
    }
    
    //Setters.
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
    //Getters.
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public char getMarca() {
        return marca;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public Arma getArma() {
        return arma;
    }
    
    //Método para generar id.
    public static String generarId() {
        return UUID.randomUUID().toString();
    }    
    
    //Método para actualizar posición.
    public void actualizarPosicion(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    //Método para mostrar datos.
    public void mostrarDatos(){
        System.out.println("--DATOS DEL PERSONAJE--");
        System.out.println("IDENTIFICADOR: "+identificador);
        System.out.println("NOMBRE: "+nombre);
        System.out.println("VIDA: "+vida);
        System.out.println("MARCA: "+marca);
        System.out.println("COORDENADA X: "+coordenadaX);
        System.out.println("COORDENADA Y: "+coordenadaY);
        System.out.println("ARMA: "+arma);
    }
}
