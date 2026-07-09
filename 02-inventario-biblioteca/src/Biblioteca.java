import java.util.ArrayList;

public class Biblioteca {
    // Listas principales de la aplicación.
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> prestamos;
    private int siguienteId;

    public Biblioteca() {
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
        siguienteId = 1;
    }

    public void agregarLibro(String titulo, String autor, int anioPublicacion) {
        Libro libro = new Libro(siguienteId, titulo, autor, anioPublicacion);
        libros.add(libro);
        siguienteId++;
        System.out.println("Libro añadido correctamente.");
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            libro.mostrarInformacion();
        }
    }

    public void buscarPorTitulo(String textoBusqueda) {
        boolean encontrado = false;

        for (Libro libro : libros) {
            // Se usa toLowerCase para que la búsqueda no dependa de mayúsculas o minúsculas.
            if (libro.getTitulo().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                libro.mostrarInformacion();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros con ese título.");
        }
    }

    public void prestarLibro(int id, String nombreUsuario, String fechaPrestamo) {
        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            System.out.println("No existe ningún libro con ese ID.");
        } else if (libro.isPrestado()) {
            System.out.println("El libro ya está prestado.");
        } else {
            libro.setPrestado(true);
            prestamos.add(new Prestamo(libro, nombreUsuario, fechaPrestamo));
            System.out.println("Préstamo registrado correctamente.");
        }
    }

    public void devolverLibro(int id) {
        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            System.out.println("No existe ningún libro con ese ID.");
            return;
        }

        if (!libro.isPrestado()) {
            System.out.println("Ese libro no está prestado.");
            return;
        }

        libro.setPrestado(false);

        // Eliminamos el préstamo asociado al libro devuelto.
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getLibro().getId() == id) {
                prestamos.remove(i);
                break;
            }
        }

        System.out.println("Libro devuelto correctamente.");
    }

    public void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            prestamo.mostrarInformacion();
        }
    }

    private Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
}
