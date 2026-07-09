/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/**
 *
 * @author recio
 */
public class Constantes {
    //Creamos la constante de la contraseña y le asignamos el valor.
    public final static int PASSWORD=12345;
    
    //Constantes para las coordenadas de la comisaria.
    public final static int UBICACION_COMISARIA_FILA=5;
    public final static int UBICACION_COMISARIA_COLUMNA=8;
    
    // Colores de letra
    public static final String BORRAR = "\u001B[0m"; //borrar      
    public static final String NEGRO = "\033[30m";
    public static final String ROJO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARILLO = "\033[33m";
    public static final String AZUL = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CELESTE = "\033[36m";
    public static final String BLANCO = "\033[37m";
    
    // Colores de fondo
    public static final String FONDO_ROJO = "\033[41m";
    public static final String FONDO_VERDE = "\033[42m";
    public static final String FONDO_AMARILLO = "\033[43m";
    public static final String FONDO_AZUL = "\033[44m";
    public static final String FONDO_MAGENTA = "\033[45m";
    public static final String FONDO_CELESTE = "\033[46m";
    public static final String FONDO_GRIS = "\033[47m";
}
