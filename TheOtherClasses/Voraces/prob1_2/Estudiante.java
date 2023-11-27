package TheOtherClasses.Voraces.prob1_2;

public class Estudiante {
    private String nombre, apellidos; //nombre apellidos alumno
    private double nota;

    public Estudiante(String nombre, String apellidos, double nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}