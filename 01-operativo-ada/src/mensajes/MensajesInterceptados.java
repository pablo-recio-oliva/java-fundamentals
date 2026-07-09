/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajes;

import java.util.Scanner;

/**
 *
 * @author recio
 */
public class MensajesInterceptados {
    
    //Método que descifra los mensajes
    public static String descifrarMensaje(String mensaje, int desplazamiento) {
        //Array que contiene el alfabeto, tanto en mayuscula como en minuscula.
        char[] alfabeto = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        char[] alfabetoMay = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();

        //Convertir el mensaje en un array de caracteres
        char[] mensajeArray = mensaje.toCharArray();

        //Array que almacena el mensaje cifrado
        char[] mensajeCifradoArray = new char[mensajeArray.length];

        for (int i = 0; i < mensajeArray.length; i++) {
            char letra = mensajeArray[i];

            if (contiene(alfabeto, letra)) {
                int nuevaPosicion = (posicionArray(alfabeto, letra) + desplazamiento) % alfabeto.length;
                mensajeCifradoArray[i] = alfabeto[nuevaPosicion];
                
            } else if (contiene(alfabetoMay, letra)) {
                int nuevaPosicion = (posicionArray(alfabetoMay, letra) + desplazamiento) % alfabetoMay.length;
                mensajeCifradoArray[i] = alfabetoMay[nuevaPosicion];
                
            } else {
                mensajeCifradoArray[i] = letra;
            }
        }

        return new String(mensajeCifradoArray);
    }

    //Método para saber si se encuentra en el array
    public static boolean contiene(char[] array, char letra) {
        boolean contiene = false;
        for (char c : array) {
            if (c == letra) {
                contiene = true;
            }
        }
        return contiene;
    }

    //Método para obtener la posición del caracter
    public static int posicionArray(char[] array, char letra) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letra) {
                return i;
            }
        }
        return -1; 
    }
    
    //Metodo main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("¿Qué mensaje quieres descifrar?");
            String mensaje = scanner.nextLine();

            System.out.println("¿Cuál es el desplazamiento?");
            int desplazamiento = scanner.nextInt();
            scanner.nextLine();

            if (desplazamiento < 0) {
                System.out.println("El desplazamiento debe ser un número positivo.");
                return;
            }

            System.out.println("Descifrando mensaje...");
            String mensajeCifrado = descifrarMensaje(mensaje, desplazamiento);

            System.out.println("Mensaje descifrado correctamente:");
            System.out.println(mensajeCifrado);

        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido para el desplazamiento.");
        }
    }
}
