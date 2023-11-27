package TheOtherClasses.Voraces.prob1_2;

import java.util.ArrayList;

public class Grupo {
    // Un Grupo es un conjunto de N estudiantes
    private ArrayList<Estudiante> alumnos;
    private int maxAlumnos;
    public Grupo(int maxAlumnos){
        alumnos = new ArrayList<Estudiante>(); this.maxAlumnos=maxAlumnos;
    }
    public Grupo(ArrayList<Estudiante> lista, int maxAlumnos){
        alumnos = new ArrayList<Estudiante>(lista); this.maxAlumnos=maxAlumnos;
    }

    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getAlumnosRestantes(){ return maxAlumnos-alumnos.size();}
    public void aniadeAlumno(Estudiante e){ alumnos.add(e);}
}