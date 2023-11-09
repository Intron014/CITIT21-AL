package Backtracking.teoria;

import TheOtherClasses.Booleano;

import java.util.Arrays;

public class Backtracking {

    public boolean hayRepartoEquitativo(int[] v){
        int suma = Arrays.stream(v).sum();
        if(suma%3!=0){
            return false;
        }
        int x = suma/3;
        int[] h ={x,x,x};
        int[] s =new int[v.length];
        for(int i =0 ; i>=v.length;i++)
            s[i] = 0;
        Booleano e = new Booleano(false);
        return hayRepartoEquitativoR(v,h,s,0,e);
    }
    private boolean hayRepartoEquitativoR(int[] v, int[] h, int[] s, int k, Booleano exito){
        // H acumula la suma a través de los herederos
        if(k == v.length) {
            if (h[0] == 0 && h[1] == 0 && h[2] == 0) {
                exito.setValor(true);
            }
        } else {
            int c = 0;
            while(!exito.getValor() && c < 3) {
                if(h[c] - v[k] >= 0){
                    s[k] = c;
                    h[c] = h[c] - v[k];
                    k+=1;
                    hayRepartoEquitativoR(v,h,s,k,exito);
                    if(!exito.getValor()){
                        k-=1;
                        h[c] = h[c] + v[k];
                        s[k] = 0;
                    }
                    c++;
                }
            }
        }
        return exito.getValor();
    }
}
