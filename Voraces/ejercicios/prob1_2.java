package Voraces.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;

public class prob1_2 {

    public ArrayList<Grupo> mezclaEstudiantes(ArrayList<Estudiante> listaEst, int numMaxAlumnos){
        Estudiante mejor = null;
        Estudiante peor = null;
        ArrayList<Grupo> solucion = new ArrayList<Grupo>();
        while(!listaEst.isEmpty()){
            mejor = seleccionarMayorNota(listaEst);
            peor = seleccionarPeorNota(listaEst);
            listaEst.remove(mejor);
            listaEst.remove(peor);

            addCandidate(solucion, numMaxAlumnos, mejor, peor);
        }
        return solucion;
    }

    private Estudiante seleccionarMayorNota(ArrayList<Estudiante> listEst){
        Estudiante max = listEst.get(0);
        for(int i=1 ; i < listEst.size(); i++){
            if(listEst.get(i).getNota() > max.getNota()){
                max = listEst.get(i);
            }
        }
        return max;
    }
    private Estudiante seleccionarPeorNota(ArrayList<Estudiante> listEst){
        Estudiante min = listEst.get(0);
        for(int i=1 ; i < listEst.size(); i++){
            if(listEst.get(i).getNota() < min.getNota()){
                min = listEst.get(i);
            }
        }
        return min;
    }

    private void addCandidate(ArrayList<Grupo> grupos, int numMaxAlumnos, Estudiante mejor, Estudiante peor){
        Grupo grupo = null;
        if(grupos.isEmpty()){
            grupo = new Grupo(numMaxAlumnos);
            grupo.aniadeAlumno(mejor);
            grupo.aniadeAlumno(peor);
            grupos.add(grupo);
        } else {
            grupo = grupos.get(grupos.size()-1);
            if(grupo.getAlumnosRestantes()>=2){
                grupo.aniadeAlumno(mejor);
                grupo.aniadeAlumno(peor);
            } else {
                grupo = new Grupo(numMaxAlumnos);
                grupo.aniadeAlumno(mejor);
                grupo.aniadeAlumno(peor);
                grupos.add(grupo);
            }
        }
    }


    // Clases Requeridas
    private class Estudiante {
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
    private class Grupo {
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

}


