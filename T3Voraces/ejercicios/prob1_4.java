package T3Voraces.ejercicios;

import java.util.ArrayList;
import TheOtherClasses.Voraces.prob1_4.*;
public class prob1_4 {

    public ArrayList<Contenedor> rescate (ArrayList<Contenedor> contenedores, int hundir){
        Contenedor c = null;
        ArrayList<Contenedor> solucion = new ArrayList<Contenedor>();
        while(hundir>0 && !contenedores.isEmpty()){
            c = seleccionarContenedor(contenedores);
            contenedores.remove(c);
            if(hundir-c.getTiempo()>=0){
                solucion.add(c);
                hundir -= c.getTiempo();
            }
        }
        if(solucion.isEmpty())
            return null;
        else
            return solucion;
    }
    private Contenedor seleccionarContenedor (ArrayList<Contenedor> contenedores){
        Contenedor mejor = null;
        for(Contenedor cont : contenedores){
            if(mejor==null || (cont.getBeneficio() > mejor.getBeneficio())){
                mejor = cont;
            }
        }
        return mejor;
    }
}
