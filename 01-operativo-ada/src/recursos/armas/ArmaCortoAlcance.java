/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author recio
 */
public class ArmaCortoAlcance extends Arma{
    //Atributo.
    private int alcance;

    //Constructor parametrizado.
    public ArmaCortoAlcance(int alcance, int diametroBala) {
        super(15, diametroBala);
        this.alcance = alcance;
    }

    //Constructor sin parametrizar
    public ArmaCortoAlcance() {
        super(15, 0);
        this.alcance = 0;
    }

    //Setter.
    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }
    
    //Getter.
    public int getAlcance() {
        return alcance;
    }

    @Override
    public String toString() {
        return "Arma de corto alcance "+super.toString()+"\nalcance=" + alcance;
    }
    
    //Método para mostrar datos.
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("ALCANCE: "+alcance);
    }
    
    //Implementación del método abstracto.
    @Override
    public void disparar(recursos.personajes.Personaje enemigo) {
        if (enemigo.getVida()>getDaño()){
            enemigo.setVida(enemigo.getVida()-getDaño());
            System.out.println(enemigo.getNombre()+" | Vida restante: "+enemigo.getVida());
            System.out.println("Alcance del disparo realizado: "+getAlcance()+" metros");
        }
        else{
            enemigo.setVida(0);
            System.out.println("Enemigo: "+enemigo.getNombre()+" abatido");
        }
    }
}
