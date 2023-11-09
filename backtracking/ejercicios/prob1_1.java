package backtracking.ejercicios;

import inventedClasses.Booleano;

public class prob1_1 {

    /*
     El 10 de agosto del año 843, Lotario I, Luis el Germánico y Carlos el
     Calvo (hijos de Ludovico Pio y nietos de Carlomagno) plantean en Verdún la
     posibilidad de llegar a un pacto (el conocido como tratado de Verdún) para repartir
     la vasta herencia de Carlomagno y poner así fin a la larga guerra civil carolingia.
     Con el fin de facilitar el acuerdo, se nos pide implementar un algoritmo de
     backtracking que permita determinar si es posible realizar un reparto equitativo
     */

    public boolean hayRepartoEquitativo(int[] bienes){
        int suma = 0;
        for (int i : bienes) {
            suma += i;
        }
        if(suma%3==0) {
            Booleano exito = new Booleano(false);
            int[] falta = {suma / 3, suma / 3, suma / 3};
            hRER(bienes, 0, falta, exito);
            return exito.getValor();
        } else return false;
    }

    private void hRER(int[] bienes, int lvl, int[] falta, Booleano exito){
        if(lvl== bienes.length){
            if(falta[0]==falta[1] && falta[1]==falta[2]){
                exito.setValor(true);
            }
        } else {
            int c = 0;
            while((c<3) && !exito.getValor()){
                if(bienes[lvl]<falta[c]){
                    falta[c] = falta[c] + bienes[lvl];
                    hRER(bienes, c+1, falta, exito);
                    if(!exito.getValor()){
                        falta[c] = falta[c] - bienes[lvl];
                    }
                }
                c++;
            }
        }
    }
}
