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
public class Policia extends Personaje implements Jugable{
   //Atributos
   private int numeroPlaca;
   private String departamento;
   private String permisoArma;
   private String rango; 
   
   //Constructor parametrizado.
    public Policia(int numeroPlaca, String departamento, String permisoArma, String rango, String identificador, String nombre, int vida, char marca, int coordenadaX, int coordenadaY, Arma arma) {
        super(identificador, nombre, vida, marca, coordenadaX, coordenadaY, arma);
        this.numeroPlaca = numeroPlaca;
        this.departamento = departamento;
        this.permisoArma = permisoArma;
        this.rango = rango;
    }
   
    public Policia(String nombre, char marca, int coordenadaX, int coordenadaY, Arma arma, String departamento, String permisoArma, String rango) {
        super(nombre, marca, coordenadaX, coordenadaY, arma);
        this.numeroPlaca = generarNumeroPlaca();
        this.departamento = departamento;
        this.permisoArma = permisoArma;
        this.rango = rango;
    }
    
    //Constructor sin parametrizar.
    public Policia() {
        super(Personaje.generarId(), "", 100, 'x', 0, 0, new ArmaCortoAlcance());
        this.numeroPlaca = 0;
        this.departamento = "";
        this.permisoArma = "";
        this.rango = "";
    }
    
    //Setters.
    public void setNumeroPlaca(int numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setPermisoArma(String permisoArma) {
        this.permisoArma = permisoArma;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
   
    //Getters.
    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getPermisoArma() {
        return permisoArma;
    }

    public String getRango() {
        return rango;
    }

    @Override
    public String toString() {
        return "Policia{" +"nombre=" + super.getNombre() + ", numeroPlaca=" + numeroPlaca + ", departamento=" + departamento + ", permisoArma=" + permisoArma + ", rango=" + rango + '}';
    }
    
    //Método para generar un número de placa aleatorio entre 0 y 5000.
    public static int generarNumeroPlaca() {
        return (int) (Math.random() * 5001);
    }
    
   //Método para mostrar datos.
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("NUMERO DE PLACA: "+numeroPlaca);
        System.out.println("DEPARTAMENTO: "+numeroPlaca);
        System.out.println("PERMISO ARMA: "+numeroPlaca);
        System.out.println("RANGO: "+numeroPlaca);
    }

    //Métodos de la interfaz Jugable
    /*@Override
    public void atacar(Personaje enemigo) {
        System.out.println("Policia atacando...");
    }
    */
    @Override
    public void esquivar() {
        int coordenadaActual = getCoordenadaX();
        int movimientoAleatorio = (int) ((Math.random()*3) -1);
        if (movimientoAleatorio != 0){
            int coordenadaXnew = getCoordenadaX() + movimientoAleatorio;
            System.out.println("Policia: "+getNombre()+" se mueve en X de "+coordenadaActual+" a "+coordenadaXnew);
        }
        else{
            System.out.println("Policia: "+getNombre()+" mantiene su posicion en X");
        }
    }

    @Override
    public void defender() {
        int escudoAleatorio = (int) (Math.random()*(15 - 5 + 1)+5);
        if (getVida() + escudoAleatorio <= 100){
            setVida(escudoAleatorio+getVida());
        }
        else{
            setVida(100);
        }
        System.out.println("Policia: "+getNombre()+" crea escudo de "+escudoAleatorio+" | Vida: "+getVida());
    }
    
    //Metodo atacar modificado mision 05
    @Override
    public void atacar(Personaje enemigo) {
        if (enemigo.getVida() <= 0) {
            System.out.println("El enemigo ya está abatido.");
        } else {
            System.out.println("Policía: " + getNombre() + " se prepara para atacar.");
            if (getArma() == null) {
                System.out.println("Policía: " + getNombre() + " no tiene arma asignada.");
            } else {
                if (getArma().obtenerNumeroBalas() < 3) {
                    System.out.println("El arma del policía: " + getNombre() + " no tiene balas suficientes.");
                    getArma().cargarArma();
                }
                getArma().apuntar(enemigo);
                int disparos = 0;
                while (enemigo.getVida() > 0 && disparos < 3) {
                    getArma().eliminarBala();
                    getArma().disparar(enemigo);
                    disparos++;
                }
            }
        }
    }

}
