/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entrenamiento;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class Entrenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Misión 1.A
        
        //Creamos las variables para cada lado de ZE1 y su perimetro.
        double l1ze1 = 20, l2ze1 = 63, l3ze1 = 20, l4ze1 = 23;
        double pze1 = l1ze1 + l2ze1 + l3ze1 + l4ze1;
        //Creamos las variables para cada lado de ZE2 y su perimetro.
        double l1ze2 = 63.2, l2ze2 = 59.05, l3ze2 = 51.83, l4ze2 = 32.7, l5ze2 = 6.3, l6ze2 = 10.3; 
        double pze2 = l1ze2 + l2ze2 + l3ze2 + l4ze2 + l5ze2 + l6ze2;
        //Creamos las variables para cada lado de ZE3 y su perimetro.
        double l1ze3 = 17.71 ,l2ze3 = 17.71 ,l3ze3 = 17.71 ,l4ze3 = 17.71;
        double pze3 = l1ze3 + l2ze3 + l3ze3 + l4ze3;
        //Creamos las variables para cada lado de ZE4 y su perimetro.
        double l1ze4 = 15 ,l2ze4 = 20.5 ,l3ze4 = 12.8 ,l4ze4 = 25.29;
        double pze4 = l1ze4 + l2ze4 + l3ze4 + l4ze4;
        
        //Ahora toca imprimir el resultado en pantalla.
        //Imprimimos la información de ZE1.
        System.out.println("ZE1 - cuadrado: " + l1ze1 + " + " + l2ze1 + " + " + l3ze1 + " + " + l4ze1 + " -> Perimetro: "+ pze1 +"m");
        //Imprimimos la información de ZE2.
        System.out.println("ZE2 - hexagono: " + l1ze2 + " + " + l2ze2 + " + " + l3ze2 + " + " + l4ze2 + " + " + l5ze2 + " + " + l6ze2 + " -> Perimetro: "+ pze2 +"m");
        //Imprimimos la información de ZE3.
        System.out.println("ZE3 - cuadrado: " + l1ze3 + " x 4 -> Perimetro: "+ pze3 +"m");
        //Imprimimos la información de ZE4.
        System.out.println("ZE1 - cuadrado: " + l1ze4 + " + " + l2ze4 + " + " + l3ze4 + " + " + l4ze4 + " -> Perimetro: "+ pze4 +"m");
        
        //Misión 1.B
        
        //Creamos las variables para cada distancia.
        //Primer recorrido (de la comisaría al palacio).
        double rec1 = 2.6 + 1.3 + 5.23;
        //Segundo recorrido (de la comisaría a ZE3).
        double rec2 = 2.6 + 1.3 + 2.42;
        //Tercer recorrido (de la comisaría a ZE4).
        double rec3 = 2.9 + 1.3;
        //Cuarto recorrido (de la plaza al palacio de congresos).
        double rec4 = 0.8 + 1.3 + 5.23;
        
        //Ahora hay que mostrar en pantalla cuanto se tardará en realizar cada recorrido.
        //Recorrido 1.
        System.out.println("Los tiempos que se tardan en ir de la comisaria al palacio son los siguientes:\nAndando: " + (rec1 * 60) / 5 + " minutos.\nCorriendo: " + (rec1 * 60) / 10 + " minutos.\nEn coche: " + (rec1 * 60) / 50 + " minutos");
        //Recorrido 2.
        System.out.println("Los tiempos que se tardan en ir de la comisaria a ZE3 son los siguientes:\nAndando: " + (rec2 * 60) / 5 + " minutos.\nCorriendo: " + (rec2 * 60) / 10 + " minutos.\nEn coche: " + (rec2 * 60) / 50 + " minutos");
        //Recorrido 3.
        System.out.println("Los tiempos que se tardan en ir de la comisaria a ZE4 son los siguientes:\nAndando: " + (rec3 * 60) / 5 + " minutos.\nCorriendo: " + (rec3 * 60) / 10 + " minutos.\nEn coche: " + (rec3 * 60) / 50 + " minutos");
        //Recorrido 4.
        System.out.println("Los tiempos que se tardan en ir de la plaza al palacio de congresos son los siguientes:\nAndando: " + (rec4 * 60) / 5 + " minutos.\nCorriendo: " + (rec4 * 60) / 10 + " minutos.\nEn coche: " + (rec4 * 60) / 50 + " minutos");
    
        //Misión 1.C
        
        Scanner entrada = new Scanner (System.in);
        
        //Creamos la variable que necesitamos.
        double distancia;
        
        //Ahora creamos el mensaje que se mostrará en pantalla para que el usuario introduzca los datos.
        System.out.println("Introduzca la distancia a recorrer en Km");
        //Ahora le pedimos al usuario que introduzca la cantidad.
        distancia = entrada.nextDouble();
        //A continuación, mostramos el resultado final.
        System.out.println("Los tiempos que se tardan en recorrer " + distancia + " Km son:\nAndando: " + (distancia * 60) / 5 + " minutos\nCorriendo: " + (distancia * 60) / 10 + " minutos\nEn coche: " + (distancia * 60) / 50 + " minutos");
    }
    
}
