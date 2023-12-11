package T3Voraces.exams;
import TheOtherClasses.Voraces.jul2021.*;

import java.util.ArrayList;

public class jul2021 {

    /**
     * El famoso periodista político Tony Iron en su afamado programa de TV Red Hot
     * ha contratado una empresa para que le diseñen su Pactometer, un algoritmo que permita
     * generar el conjunto de pactos posibles entre un grupo de partidos políticos que se han
     * presentado a las elecciones. El Pactometer debe tener en cuenta tanto el número de escaños
     * conseguidos por cada partido como el desgaste político que supone pactar con otros partidos.
     * Para un total de N diputados, será necesario que en el pacto haya, al menos, ((𝑁/2) +
     * 1) diputados para obtener la mayoría absoluta. Siempre se debe elegir como partido
     * principal para formar gobierno el que tenga mayor número de diputados electos. De
     * cada partido (𝑝!) se conoce el nº de diputados (𝑑!) obtenidos en las elecciones (𝑁 ≥ 𝑑! ≥ 1),
     * así como su orientación política (que se mide en una escala entre 1 y 10: 1 extrema izquierda,
     * 10 extrema derecha).
     * El nivel de perjuicio que supondrá para un partido político 𝑝!, pactar con otro 𝑝", dependerá
     * de la distancia entre sus ideologías políticas. 𝑃𝑒𝑟𝑗𝑢𝑖𝑐𝑖𝑜5𝑝!, 𝑝" 7 = (9𝑜! − 𝑜"9), es una función que
     * devuelve un valor entre [0..1], y que depende de los valores de (𝑜!, 𝑜") que representan las
     * orientaciones de cada uno de estos partidos. Para determinar si un partido realiza o no un
     * pacto, existirá un umbral μ € [0..1], de modo que si 𝑃𝑒𝑟𝑗𝑢𝑖𝑐𝑖𝑜5𝑝!, 𝑝" 7 ≥ μ el pacto entre 𝑝! y 𝑝"
     * no será aceptable
     */

    public ArrayList<Partido> greedyPactometer(ArrayList<Partido> misPartidos, int mayoriaABS, float umbralPacto){
        ArrayList<Partido> solucion = new ArrayList<>();
        Partido candidato = null;
        int numDiputados = 0;
        Partido pprincipal = seleccionarPartido(misPartidos);
        solucion.add(pprincipal);
        misPartidos.remove(pprincipal);
        numDiputados += pprincipal.getDiputados();
        while((numDiputados < mayoriaABS) && !misPartidos.isEmpty()){
            candidato = seleccionarPartido(misPartidos);
            misPartidos.remove(candidato);
            if(pprincipal.Perjuicio(candidato) < umbralPacto){
                solucion.add(candidato);
                numDiputados += candidato.getDiputados();
            }
        }
        if(numDiputados < mayoriaABS)
            return null;
        else
            return solucion;
    }

    private Partido seleccionarPartido(ArrayList<Partido> candidatos){
        Partido candidato = null;
        int mejor = 0;
        for(int i=0 ; i < candidatos.size() ; i++){
            if(candidatos.get(i).getDiputados() > mejor){
                mejor = candidatos.get(i).getDiputados();
                candidato = candidatos.get(i);
            }
        }
        return candidato;
    }


}
