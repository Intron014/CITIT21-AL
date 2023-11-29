package T3Voraces.exams;

import TheOtherClasses.Voraces.dec2017.*;

import java.util.ArrayList;

public class dec2017 {

    /*
     La filmoteca ha organizado un maratón de cine de
     terror. Durante 24 horas se proyectarán películas (todas diferentes) en las N salas
     disponibles. El Joker, gran aficionado a este género de películas, ha conseguido la programación
     completa donde aparecen todas las películas que se van a proyectar durante el maratón:
     junto con el título, nombre del director, duración de la película y otros datos de interés,
     se indica la sala de proyección y la hora de comienzo. El objetivo del Joker es ver el
     máximo número posible de películas. Ayúdale a planificar su maratón de cine,
     implementando el método ArrayList<Pelicula> obtenerListado(ArrayList<Pelicula> candidatos)
     en Java, basado en un esquema voraz, que devuelva la lista de películas seleccionadas.
     */

    public ArrayList<Pelicula> obtenerListado(ArrayList<Pelicula> candidatos){
        ArrayList<Pelicula> solucion = new ArrayList<>();
        Pelicula candidato;
        while(!candidatos.isEmpty()){
            candidato = seleccionarCandidato(candidatos);
            candidatos.remove(candidato);
            if(isFactible(candidatos, candidato)){
                solucion.add(candidato);
            }
        }
        if(!solucion.isEmpty())
            return solucion;
        else
            return null;
    }

    private Pelicula seleccionarCandidato(ArrayList<Pelicula> candidatos){
        Pelicula best = null;
        for(Pelicula selected : candidatos){
            if((best == null || (best.getFin() > selected.getFin())))
                best = selected;
        }
        return best;
    }

    private boolean isFactible(ArrayList<Pelicula> solucion, Pelicula doesItFit){
        boolean itFits = true;
        if(solucion.size()>0){
            if(solucion.getLast().getFin() > doesItFit.getInicio()){ //or "solucion.get(solucion.size()-1).getFin()"
                itFits = false;
            }
        }
        return itFits;
    }

    //private Pelicula seleccionarCandidatoMine(ArrayList<Pelicula> candidatos){
    //    Pelicula best = candidatos.get(0);
    //    for(int i = 1 ; i < candidatos.size() ; i++){
    //        if(best.getFin() > candidatos.get(i).getFin())
    //            best = candidatos.get(i);
    //    }
    //    return best;
    //}
}
