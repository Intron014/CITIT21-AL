package backtracking.ejercicios;

import inventedClasses.Entero;

public class prob1_3 {
    public boolean[] maxUsoRecurso(int[] comienzo, int[] fin){
        boolean[] seleccionados = new boolean[comienzo.length];
        boolean[] mejorSeleccionados = new boolean[comienzo.length];
        int usoRecurso = 0;
        Entero mejorUsoRecurso = new Entero(Integer.MIN_VALUE);
        mURR(comienzo, fin, 0, seleccionados, usoRecurso, mejorSeleccionados, mejorUsoRecurso);
        return mejorSeleccionados;
    }
    private void mURR(int[] comienzo, int[] fin, int tarea, boolean[] seleccionados, int usoRecurso, boolean[] mejorSeleccionados, Entero mejorUsoRecurso){
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
