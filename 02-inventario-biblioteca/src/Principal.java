import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        cargarDatosIniciales(biblioteca);

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    registrarLibro(scanner, biblioteca);
                    break;
                case 2:
                    biblioteca.mostrarLibros();
                    break;
                case 3:
                    System.out.print("Introduce parte del título: ");
                    biblioteca.buscarPorTitulo(scanner.nextLine());
                    break;
                case 4:
                    prestarLibro(scanner, biblioteca);
                    break;
                case 5:
                    int idDevolucion = leerEntero(scanner, "ID del libro a devolver: ");
                    biblioteca.devolverLibro(idDevolucion);
                    break;
                case 6:
                    biblioteca.mostrarPrestamos();
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
        System.out.println("\n=== INVENTARIO DE BIBLIOTECA ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Mostrar catálogo");
        System.out.println("3. Buscar libro por título");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Mostrar préstamos activos");
        System.out.println("0. Salir");
    }

    private static void registrarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        int anio = leerEntero(scanner, "Año de publicación: ");
        biblioteca.agregarLibro(titulo, autor, anio);
    }

    private static void prestarLibro(Scanner scanner, Biblioteca biblioteca) {
        int id = leerEntero(scanner, "ID del libro a prestar: ");

        System.out.print("Nombre del usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Fecha del préstamo: ");
        String fecha = scanner.nextLine();

        biblioteca.prestarLibro(id, usuario, fecha);
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

    private static void cargarDatosIniciales(Biblioteca biblioteca) {
        // Datos de ejemplo para que la aplicación tenga contenido al ejecutarse por primera vez.
        biblioteca.agregarLibro("El juego de Ender", "Orson Scott Card", 1985);
        biblioteca.agregarLibro("1984", "George Orwell", 1949);
        biblioteca.agregarLibro("Clean Code", "Robert C. Martin", 2008);
    }
}
