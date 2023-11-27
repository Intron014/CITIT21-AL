package T2Backtracking.ejercicios;

import TheOtherClasses.Booleano;

public class prob1_2 {

    /*
     Dado un vector, v, que contiene los valores de un conjunto de elementos, se
     desea comprobar si existen dos subconjuntos de elementos tal que la suma de valores de
     cada subconjunto sea exactamente igual a un valor predeterminado vObjetivo.
     */

    public boolean dosSubconjuntos(int[] v, int vObjetivo){
        Booleano viva = new Booleano(false);
        dSR(v, vObjetivo, 0, 0, 0, viva);
        return viva.getValor();
    }

    private void dSR(int[] v, int vObjetivo, int subA, int subB, int lvl, Booleano success){
        if(subA == vObjetivo && subB == vObjetivo){
            success.setValor(true);
        } else {
            if(lvl < v.length){
                int c = 0;
                // c0 --> No asignation
                // c1 --> Al subA
                // c2 --> Al subB
                while(c < 3 && !success.getValor()){
                    if(c==0 || ((c==1) && subA + v[lvl] <=vObjetivo) || ((c==2) && subB + v[lvl] <= vObjetivo)){
                        if(c==1){
                            subA += v[lvl];
                        } else if (c == 2){
                            subB += v[lvl];
                        }
                        dSR(v, vObjetivo, subA, subB, lvl + 1, success);
                        if(!success.getValor()) {
                            if (c == 1) {
                                subA -= v[lvl];
                            } else if (c == 2) {
                                subB -= v[lvl];
                            }
                        }
                    }
                    c++;
                }
            }
        }
    }

}
