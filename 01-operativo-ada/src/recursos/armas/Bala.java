/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos.armas;

/**
 *
 * @author recio
 */
public class Bala {
    //Atributo.
    private int diametro;
    
    //Constructor parametrizado.
    public Bala(int diametro) {
        this.diametro = diametro;
    }

    //Constructor sin parametrizar.
    public Bala() {
        this.diametro = 0;
    }

    //Setter.
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    
    //Getter.
    public int getDiametro() {
        return diametro;
    }
    
    //Método para mostrar datos.
    public void mostrarDatos(){
        System.out.println("--BALA--");
        System.out.println("DIAMETRO: "+diametro);
    }
}
