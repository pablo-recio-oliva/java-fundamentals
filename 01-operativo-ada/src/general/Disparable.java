/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package general;

/**
 *
 * @author recio
 */
public interface Disparable {
    //Métodos de la interfaz.
    public void apuntar(recursos.personajes.Personaje enemigo);
    public void cargarArma();
    public int obtenerNumeroBalas();
    public void eliminarBala();
}
