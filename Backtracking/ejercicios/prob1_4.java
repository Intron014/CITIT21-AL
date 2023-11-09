package Backtracking.ejercicios;

import TheOtherClasses.Entero;

public class prob1_4 {

    /*
     Se dispone de dos contenedores, cada uno capaz de soportar un peso máximo,
     y un conjunto de productos, cada uno con un peso característico. Se pretende distribuir
     todos los productos entre los dos contenedores de forma que el reparto del peso sea lo
     más equilibrado posible
     */

    public int[] distribucionCarga2(int[] pesos, int pmax){
        int[] distrib = new int[pesos.length];
        int[] mejorDist = new int[pesos.length];
        int[] pesoAcumul = {0, 0};
        int nivel = 0;
        Entero mejorDif = new Entero(Integer.MAX_VALUE);
        for(int i = 0 ; i < pesos.length ; i++){
            distrib[i] = 0; mejorDist[i] = 0;
        }
        dC2R(pesos, pmax, nivel, distrib, pesoAcumul, mejorDist, mejorDif);
        return mejorDist;
    }

    private void dC2R(int[] pesos, int pmax, int nivel, int[] distrib, int[] pesoAcumul,
                      int[] mejorDist, Entero mejorDif){
        if(nivel == pesos.length){
            int diferencia = Math.abs(pesoAcumul[0] - pesoAcumul[1]);
            if(diferencia < mejorDif.getValor()){
                mejorDif.setValor(diferencia);
                System.arraycopy(distrib, 0, mejorDist, 0, distrib.length);
            }
        } else {
            for(int c = 0; c < 2 ; c++){
                if((pesoAcumul[c] + pesos[nivel]) <= pmax){
                    distrib[nivel] = c + 1;
                    pesoAcumul[c] = pesoAcumul[c] + pesos[nivel];
                    dC2R(pesos, pmax, nivel + 1, distrib, pesoAcumul, mejorDist, mejorDif);
                    pesoAcumul[c] = pesoAcumul[c] - pesos[nivel];
                    distrib[nivel] = 0;
                }
            }
        }
    }

}
