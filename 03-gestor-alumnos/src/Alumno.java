import java.util.ArrayList;

public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private ArrayList<Nota> notas;

    public Alumno(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public void agregarNota(String asignatura, double calificacion) {
        notas.add(new Nota(asignatura, calificacion));
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0;
        }

        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getCalificacion();
        }

        return suma / notas.size();
    }

    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    public void mostrarResumen() {
        String estado = estaAprobado() ? "Aprobado" : "Suspenso";
        System.out.printf("ID: %d | %s | Media: %.2f | %s%n", id, getNombreCompleto(), calcularMedia(), estado);
    }

    public void mostrarExpediente() {
        System.out.println("\nAlumno: " + getNombreCompleto());
        System.out.println("ID: " + id);

        if (notas.isEmpty()) {
            System.out.println("No tiene notas registradas.");
            return;
        }

        System.out.println("Notas:");
        for (Nota nota : notas) {
            nota.mostrarInformacion();
        }

        System.out.printf("Media final: %.2f%n", calcularMedia());
    }
}
