package Backtracking.ejercicios;

import TheOtherClasses.Entero;

public class prob1_3 {

    /*
     Se dispone de una lista de trabajos que tienen asociado un instante de
     comienzo ci y un instante de finalización fi, donde ci<fi, de forma que cada trabajo
     debe realizarse durante el periodo [ci,fi). Durante la realización de un trabajo es
     necesario hacer uso de un recurso único de manera exclusiva, por lo que dos
     trabajos i, j son compatibles si los intervalos [ci,fi) y [cj,fj) no se superponen. Se
     quiere obtener el conjunto de trabajos mutuamente compatibles que maximice el
     tiempo que está en uso el recurso
     */

    public boolean[] maxUsoRecurso(int[] comienzo, int[] fin){
        boolean[] seleccionados = new boolean[comienzo.length];
        boolean[] mejorSeleccionados = new boolean[comienzo.length];
        int usoRecurso = 0;
        Entero mejorUsoRecurso = new Entero(Integer.MIN_VALUE);
        mURR(comienzo, fin, 0, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);
        return mejorSeleccionados;
    }
    private void mURR(int[] comienzo, int[] fin, int tarea, boolean[] seleccionados, int usoRecurso,
                      boolean[] mejorSeleccionados, Entero mejorUsoRecurso){
        if(tarea == comienzo.length){
            if(usoRecurso > mejorUsoRecurso.getValor()){
                mejorUsoRecurso.setValor(usoRecurso);
                System.arraycopy(seleccionados, 0, mejorSeleccionados, 0, seleccionados.length);
            }
        } else {
            for(int c = 0; c < 2 ; c++){
                if((c==0) || compatible(comienzo, fin, seleccionados, tarea)){
                    seleccionados[tarea] = (c==1);
                    usoRecurso = usoRecurso + (fin[tarea] - comienzo[tarea]) * c;
                    mURR(comienzo, fin, tarea + 1, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);
                    usoRecurso = usoRecurso - (fin[tarea] - comienzo[tarea]) * c;
                    seleccionados[tarea] = false;
                }
            }
        }
    }
    private boolean compatible(int[] comienzo, int[] fin, boolean[] seleccionados, int tarea){
        boolean ok = true;
        int i = 0;
        while(ok && (i<tarea)){
            if(seleccionados[i]){
                ok = ((comienzo[i] >= fin[tarea]) || (comienzo[tarea] >= fin[i]));
            }
            i++;
        }
        return ok;
    }
}
