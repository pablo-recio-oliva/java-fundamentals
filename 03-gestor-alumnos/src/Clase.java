import java.util.ArrayList;

public class Clase {
    private ArrayList<Alumno> alumnos;
    private int siguienteId;

    public Clase() {
        alumnos = new ArrayList<>();
        siguienteId = 1;
    }

    public void agregarAlumno(String nombre, String apellidos) {
        Alumno alumno = new Alumno(siguienteId, nombre, apellidos);
        alumnos.add(alumno);
        siguienteId++;
        System.out.println("Alumno registrado correctamente.");
    }

    public void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        for (Alumno alumno : alumnos) {
            alumno.mostrarResumen();
        }
    }

    public void agregarNotaAAlumno(int id, String asignatura, double calificacion) {
        Alumno alumno = buscarAlumnoPorId(id);

        if (alumno == null) {
            System.out.println("No existe ningún alumno con ese ID.");
            return;
        }

        alumno.agregarNota(asignatura, calificacion);
        System.out.println("Nota añadida correctamente.");
    }

    public void mostrarExpediente(int id) {
        Alumno alumno = buscarAlumnoPorId(id);

        if (alumno == null) {
            System.out.println("No existe ningún alumno con ese ID.");
        } else {
            alumno.mostrarExpediente();
        }
    }

    public void mostrarAprobadosYSuspensos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("\n--- Aprobados ---");
        for (Alumno alumno : alumnos) {
            if (alumno.estaAprobado()) {
                alumno.mostrarResumen();
            }
        }

        System.out.println("\n--- Suspensos ---");
        for (Alumno alumno : alumnos) {
            if (!alumno.estaAprobado()) {
                alumno.mostrarResumen();
            }
        }
    }

    private Alumno buscarAlumnoPorId(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }
        return null;
    }
}
