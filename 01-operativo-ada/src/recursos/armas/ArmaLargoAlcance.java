/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author recio
 */
public class ArmaLargoAlcance extends Arma{
    //Atributo.
    private double velocidad;

    //Constructor parametrizado.
    public ArmaLargoAlcance(double velocidad, int diametroBala) {
        super(10, diametroBala);
        this.velocidad = velocidad;
    }

    //Constructor sin parametrizar.
    public ArmaLargoAlcance() {
        super(10, 0);
        this.velocidad = 0.0;
    }

    //Setter.
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    //Getter.
    public double getVelocidad() {
        return velocidad;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Arma de largo alcance "+super.toString()+"\nvelocidad=" + velocidad;
    }
    
    //Método para mostrar datos.
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("VELOCIDAD: "+velocidad);
    }
    
    //Implementación del método abstracto.
    @Override
    public void disparar(recursos.personajes.Personaje enemigo) {
        if (enemigo.getVida()>getDaño()){
            enemigo.setVida(enemigo.getVida()-getDaño());
            System.out.println(enemigo.getNombre()+" | Vida restante: "+enemigo.getVida());
            System.out.println("Velocidad del disparo realizado: "+getVelocidad()+" km/h");
        }
        else{
            enemigo.setVida(0);
            System.out.println("Enemigo: "+enemigo.getNombre()+" abatido");
        }
    }
}
