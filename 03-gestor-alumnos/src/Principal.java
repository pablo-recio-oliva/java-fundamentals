import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clase clase = new Clase();
        int opcion;

        cargarDatosIniciales(clase);

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner, clase);
                    break;
                case 2:
                    clase.mostrarAlumnos();
                    break;
                case 3:
                    agregarNota(scanner, clase);
                    break;
                case 4:
                    int idExpediente = leerEntero(scanner, "ID del alumno: ");
                    clase.mostrarExpediente(idExpediente);
                    break;
                case 5:
                    clase.mostrarAprobadosYSuspensos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GESTOR DE ALUMNOS ===");
        System.out.println("1. Registrar alumno");
        System.out.println("2. Mostrar alumnos");
        System.out.println("3. Añadir nota");
        System.out.println("4. Ver expediente");
        System.out.println("5. Mostrar aprobados y suspensos");
        System.out.println("0. Salir");
    }

    private static void registrarAlumno(Scanner scanner, Clase clase) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        clase.agregarAlumno(nombre, apellidos);
    }

    private static void agregarNota(Scanner scanner, Clase clase) {
        int id = leerEntero(scanner, "ID del alumno: ");

        System.out.print("Asignatura: ");
        String asignatura = scanner.nextLine();

        double calificacion = leerDouble(scanner, "Calificación entre 0 y 10: ");
        clase.agregarNotaAAlumno(id, asignatura, calificacion);
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }
        }
    }

    private static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double numero = Double.parseDouble(scanner.nextLine());

                if (numero >= 0 && numero <= 10) {
                    return numero;
                }

                System.out.println("La calificación debe estar entre 0 y 10.");
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }
        }
    }

    private static void cargarDatosIniciales(Clase clase) {
        // Datos de ejemplo para poder probar el programa sin registrar todo desde cero.
        clase.agregarAlumno("Pablo", "Recio");
        clase.agregarAlumno("Lucía", "Martín");
        clase.agregarNotaAAlumno(1, "Programación", 8.5);
        clase.agregarNotaAAlumno(1, "Bases de datos", 7.0);
        clase.agregarNotaAAlumno(2, "Programación", 4.5);
    }
}
