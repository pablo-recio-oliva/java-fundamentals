public class Nota {
    private String asignatura;
    private double calificacion;

    public Nota(String asignatura, double calificacion) {
        this.asignatura = asignatura;
        this.calificacion = calificacion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void mostrarInformacion() {
        System.out.println(asignatura + ": " + calificacion);
    }
}
