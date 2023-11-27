package T3Voraces.ejercicios;

import java.util.ArrayList;
import TheOtherClasses.Voraces.prob1_1.*;

public class prob1_1 {

    /*
     Se pretende transportar una serie de productos (p1, p2,p3, …, pN) cada uno
     con un peso característico, desde la estación espacial conjunta hasta la base lunar
     internacional. Para ello se dispone de tres naves de carga a las que denominaremos n1,
     n2 y n3.
     */

    void distribuyeCarga(ArrayList<Producto> productos, ArrayList<Producto> n1, ArrayList<Producto> n2, ArrayList<Producto> n3){
        int total1=0, total2=0, total3=0;
        Producto cand = null;
        while(!productos.isEmpty()){
            cand = seleccionarProducto(productos);
            productos.remove(cand);
            if(total1 <= total2 && total1 <= total3) {
                total1 += cand.getPeso();
                n1.add(cand);
            } else if (total2 <= total3){
                total2 += cand.getPeso();
                n2.add(cand);
            } else {
                total3 += cand.getPeso();
                n3.add(cand);
            }
        }
    }

    private Producto seleccionarProducto(ArrayList<Producto> candidatos){
        Producto max = null;
        for(Producto candidato : candidatos){
            if(max == null){
                max = candidato;
            } else if(candidato.getPeso()>max.getPeso()){
                max = candidato;
            }
        }
        return max;
    }
}
