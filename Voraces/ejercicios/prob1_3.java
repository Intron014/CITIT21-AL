package Voraces.ejercicios;

import java.util.ArrayList;

public class prob1_3{

    public ArrayList<Conjunto> conjuntoMinimo(int[] u, ArrayList<Conjunto> S){
        boolean[] visitados = new boolean[S.size()];
        for(int i = 0 ; i<u.length ; i++){
            visitados[i] = false;
        }
        ArrayList<Conjunto> solution = new ArrayList<Conjunto>();
        while(!todosVisitados(visitados)){
            Conjunto c = seleccionarConjunto(S, visitados);
            S.remove(c);
            solution.add(c);
            for(int i=0 ; i<c.longitud() ; i++)
                visitados[c.get(i)] = true;
        }
        return solution;
    }

    private int numNoVisitados(boolean[] visitados, Conjunto c){
        int contador = 0;
        for(int i=0 ; i<c.longitud() ; i++){
            if(visitados[c.get(i)]){
                contador++;
            }
        }
        return contador;
    }

    private Conjunto seleccionarConjunto(ArrayList<Conjunto> S, boolean[] visitados){
        Conjunto seleccionado = S.get(1);
        int max = numNoVisitados(visitados, seleccionado);
        for(int i = 1 ; i<S.size() ; i++){
            int actual = numNoVisitados(visitados, S.get(i));
            if(actual>max){
                max = actual;
            }
        }
        return seleccionado;
    }

    private boolean todosVisitados(boolean[] visitados){
        boolean sol = true;
        int i=0;
        while(sol && i<visitados.length){
            if(!visitados[i])
                sol = false;
            else
                i++;
        }
        return sol;
    }


    // Clases Requeridas
    public class Conjunto {
        private int[] contenido;
        public Conjunto(int[] contenido){
            this.contenido = new int[contenido.length];
            for (int i=0; i<contenido.length; i++) this.contenido[i]=contenido[i];
        }
        public int longitud(){ return this.contenido.length; }
        public int get(int posicion){ return contenido[posicion]; }
    }
}
