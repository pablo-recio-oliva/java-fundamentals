/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;
import general.Constantes;
import java.util.Scanner;
import recursos.armas.ArmaCortoAlcance;
import recursos.personajes.Cyborg;
import recursos.armas.ArmaLargoAlcance;
import recursos.lugares.Almacen;
import recursos.lugares.Comisaria;
import recursos.personajes.Policia;
/**
 *
 * @author recio
 */
public class Menu {
    //Creo la variable global de comisaria.
    public static Comisaria comisaria = new Comisaria();
    //Creo la variable global de Almacen.
    public static Almacen almacen = new Almacen();
    //Creo la variable global de jugador.
    public static Policia jugador;
    //Creo un metodo de tipo boolean para pedir la contraseña al usuario.
    public static boolean pedirPassword(){
        Scanner scanner = new Scanner(System.in);
        //Creo una variable para contar los intentos y le asigno el valor 3.
        int intentos = 3;
        //Creo un bucle que permite introducir la contraseña mientras que los intentos no lleguen a 0.
        while (intentos > 0) {
            //Se le solicita la contraseña al usuario.
            System.out.print("Introduzca la contraseña: ");
            //Creamos la variable cont, que almacenará la contraseña introducida por el usuario.
            int cont = scanner.nextInt();
            //Si la contraseña introducida coincide con la almacenada en la constante, se mostrará el mensaje de abajo y el resultado del boolean será true.
            if (cont == Constantes.PASSWORD) {
                System.out.println("Contraseña correcta. Puerta desbloqueada.");
                return true; 
            //Si la contraeña no coincide se restará un intento y se mostrará el mensaje de abajo.
            } else {
                intentos--;
                if (intentos > 0) {
                    System.out.println("Contraseña incorrecta. Inténtelo de nuevo.");
                    System.out.println("Restan " + intentos + " intentos.");
                }
            }
        }

        // Si se acaban los intentos, se muestra un mensaje y se deniega el acceso
        System.out.println("Contraseña incorrecta. Intentos agotados.");
        return false; 
    }
    //Creo un metodo que muestre el submenu del almacen.
    public static void mostrarSubmenuAlmacen() {
        Scanner scanner = new Scanner(System.in);
        //Creo una variable boolean y le asigno el valor false.
        boolean volver = false;
        //Mientras que no se cumpla volver, no se volverá al menu principal.
        while (!volver) {
            try {
                //Se muestran por pantalla las distintas opciones del menu.
                System.out.println("Submenu Almacen:");
                System.out.println("1. Elegir arma");
                System.out.println("2. Crear arma");
                System.out.println("3. Mostrar armas");
                System.out.println("4. Modificar arma");
                System.out.println("5. Eliminar arma");
                System.out.println("6. Registrar arma");
                System.out.println("7. Mostrar registro de armas");
                System.out.println("8. Volver al menu principal");
                System.out.print("Seleccione una opcion: ");
                //Creo la variable opcion, que almacena la opción que inserte el usuario.
                int opcion = scanner.nextInt();
                //Mediante un switch, indicamos que ocurrirá en cada situación.
                switch (opcion) {
                    case 1:
                        jugador.setArma(almacen.elegirArma());
                        break;
                    case 2:
                        almacen.crearArma();
                        break;
                    case 3:
                        almacen.mostrarArmas();;
                        break;
                    case 4:
                        almacen.modificarArma();
                        break;
                    case 5:
                        almacen.eliminarArma();
                        break;
                    case 6:
                        System.out.println("Registrar arma.");
                        break;
                    case 7:
                        System.out.println("Mostrar registro de armas.");
                        break;
                    case 8:
                        //En este caso, el usuario desea volver al menu anterior por lo que asignamos un true al boolean para salir del bucle.
                        volver = true;
                        break;
                    default:
                        //En caso de que el numero introducido no coincida con ninguna de las opciones se mostrará el siguiente mensaje.
                        System.out.println("Opción no valida. Intentelo de nuevo.");
                }
            //Controlamos que el usuario inserte un numero mediante un try/catch.
            } catch (Exception e) {
                //Mostramos el mensaje.
                System.out.println("Entrada no valida. Por favor, introduzca un numero.");
                //Se vuelve a solicitar una opción.
                scanner.next();
            }
        }
    }
    //Creo un metodo que muestre el submenu de comisaría.
    public static void mostrarSubmenuComisaria() {
        Scanner scanner = new Scanner(System.in);
        //Creo una variable boolean y le asigno el valor false.
        boolean volver = false;
        //Mientras que no se cumpla volver, no se volverá al menu principal.
        while (!volver) {
            try {
                System.out.println("Submenú Comisaria:");
                System.out.println("1. Elegir policia");
                System.out.println("2. Crear policia");
                System.out.println("3. Mostrar policia");
                System.out.println("4. Modificar policia");
                System.out.println("5. Eliminar policia");
                System.out.println("6. Ubicar personaje en el plano");
                System.out.println("7. Descifrar mensaje");
                System.out.println("8. Pasatiempos");
                System.out.println("9. Registrar policias");
                System.out.println("10. Mostrar registro de policias");
                System.out.println("11. Volver al menu principal");
                System.out.print("Seleccione una opción: ");
                //Creo la variable opcion, que almacena la opción que inserte el usuario.
                int opcion = scanner.nextInt();
                //Mediante un switch, indicamos que ocurrirá en cada situación.
                switch (opcion) {
                    case 1:
                        jugador = comisaria.elegirPolicia();
                        break;
                    case 2:
                        comisaria.crearPolicia();
                        break;
                    case 3:
                        comisaria.mostrarPolicias();
                        break;
                    case 4:
                        comisaria.modificarPolicia();
                        break;
                    case 5:
                        comisaria.eliminarPolicia();
                        break;
                    case 6:
                        System.out.println("Ubicar personaje en el plano.");
                        break;
                    case 7:
                        System.out.println("Descifrar mensaje.");
                        break;
                    case 8:
                        System.out.println("Pasatiempos.");
                        break;
                    case 9:
                        System.out.println("Registrar policías.");
                        break;
                    case 10:
                        System.out.println("Mostrar registro de policias.");
                        break;
                    case 11:
                        //En este caso, el usuario desea volver al menu anterior por lo que asignamos un true al boolean para salir del bucle.
                        volver = true;
                        break;
                    default:
                        //En caso de que el numero introducido no coincida con ninguna de las opciones se mostrará el siguiente mensaje.
                        System.out.println("Opción no valida. Intentelo de nuevo.");
                }
            //Controlamos que el usuario inserte un numero mediante un try/catch.    
            } catch (Exception e) {
                //Se mostrará el siguiente mensaje.
                System.out.println("Entrada no valida. Por favor, introduzca un numero.");
                //Se solicita de nuevo que se introduzcan datos.
                scanner.next();
            }
        }
    }
    //Creamos el metodo principal, que contiene el menu principal.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creo una variable tipo boolean y le asigno valor false.
        boolean salir = false;
        //Mientras que salir no se cumpla, no se saldrá del programa.
        while (!salir) {
            try {
                //Se muestran las distintas opciones del menu.
                System.out.println("Menu principal:");
                System.out.println("1. Entrar al almacen");
                System.out.println("2. Entrar a la comisaria");
                System.out.println("3. Intervenir en el refugio");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                //Creamos la variable opcion, que almacenará el numero que introduzca el usuario.
                int opcion = scanner.nextInt();
                //Creo un switch, que en funcion del numero introducido realizará una función u otra.
                switch (opcion) {
                    case 1:
                        //Aquí se solicita la contraseña antes de entrar al almacén.
                        if (pedirPassword()) {
                            //Si la contraseña es correcta, se muestra el siguiente mensaje.
                            System.out.println("Acceso concedido al almacen.");
                            //Además se llama al metodo que nos mostrará el submenu.
                            mostrarSubmenuAlmacen();
                        }
                        else{
                            //Si la contraseña no es correcta, se muestra el siguiente mensaje y no se llamará al submenu.
                            System.out.println("Acceso denegado. Programa finalizado.");
                        }
                        break;
                    case 2:
                        //En este caso se llama al metodo del submenu de la comisaria.
                        mostrarSubmenuComisaria();
                        break;
                    case 3:
                        System.out.println("Interviniendo en el refugio.");
                        break;
                    case 4:
                        //En este caso, el usuario desea salir del programa, por lo que se asigna true al boolean para detener el bucle.
                        salir = true;
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        //En caso de que el numero introducido no coincida con ninguna de las opciones se mostrará el siguiente mensaje.
                        System.out.println("Opcion no valida. Intentelo de nuevo.");
                }
            //Controlamos que el usuario inserte un numero mediante un try/catch.     
            } catch (Exception e) {
                //Se mostrará el siguiente mensaje.
                System.out.println("Entrada no valida. Por favor, introduzca un numero.");
                //Se solicita de nuevo que se introduzcan datos.
                scanner.next(); 
            }
        }
        //Creamos el arma utilizada por el grupo terrorista.
        ArmaCortoAlcance armaLiberacion = new ArmaCortoAlcance(10, 16);
        //Creamos los objetos de tipo Cyborg.
        Cyborg nexus = new Cyborg("Liderazgo", "Francia", "id", "Nexus", 100, 'N', 0, 0, armaLiberacion);
        Cyborg siren = new Cyborg("Logística", "Francia", "id", "Siren", 100, 'N', 0, 0, armaLiberacion);
        //Creamos el arma utilizada por Luna.
        ArmaLargoAlcance armaLuna = new ArmaLargoAlcance(2000.0, 20);
        //Creamos el objeto de tipo Policia.
        Policia lunaCastillo = new Policia(1, "Operaciones", "Largo alcance", "Comisaria", "id", "Luna Castillo", 100, 'L', 0, 0, armaLuna);
        //Le asignamos el objeto de Luna a la variable jugador.
        jugador = lunaCastillo;
        
    }
}
