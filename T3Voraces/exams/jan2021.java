package T3Voraces.exams;

import TheOtherClasses.Voraces.jan2021.*;

import java.lang.module.ResolutionException;
import java.util.ArrayList;

public class jan2021 {

    /*
     Uhhhh, frog game!
     yay!
     */

    public ArrayList<AgujeroRana> numDiscosGreedy(ArrayList<Integer> valoresRana, int puntuacion){
        ArrayList<AgujeroRana> solucion = new ArrayList<>();
        int value;
        while(puntuacion > 0 && (!valoresRana.isEmpty())){
            value = seleccionarCandidato(valoresRana);
            valoresRana.remove(Integer.valueOf(value));
            if((puntuacion/value)>0){
                solucion.add(new AgujeroRana(value, puntuacion/value));
                puntuacion = puntuacion%value;
            }
        }
        if(puntuacion==0)
            return solucion;
        else
            return null;
    }

    private int seleccionarCandidato(ArrayList<Integer> values){
        int mayor = Integer.MIN_VALUE;
        for(Integer disco : values)
            if(disco > mayor)
                mayor = disco;
        return mayor;
    }
}
