public class Prestamo {
    private Libro libro;
    private String nombreUsuario;
    private String fechaPrestamo;

    public Prestamo(Libro libro, String nombreUsuario, String fechaPrestamo) {
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void mostrarInformacion() {
        System.out.println("Libro: " + libro.getTitulo() + " | Usuario: " + nombreUsuario + " | Fecha: " + fechaPrestamo);
    }
}
