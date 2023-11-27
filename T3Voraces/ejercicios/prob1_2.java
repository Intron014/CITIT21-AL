package T3Voraces.ejercicios;

import java.util.ArrayList;
import TheOtherClasses.Voraces.prob1_2.*;
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
}


