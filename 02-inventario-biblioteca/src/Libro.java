public class Libro {
    // Atributos principales del libro.
    private int id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean prestado;

    // Constructor parametrizado.
    public Libro(int id, String titulo, String autor, int anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
    }

    // Getters.
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    // Setter usado cuando un libro se presta o se devuelve.
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void mostrarInformacion() {
        String estado = prestado ? "Prestado" : "Disponible";
        System.out.println("ID: " + id + " | " + titulo + " | " + autor + " | " + anioPublicacion + " | " + estado);
    }
}
