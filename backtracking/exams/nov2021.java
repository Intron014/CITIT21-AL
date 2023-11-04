package backtracking.exams;
import inventedClasses.*;
public class nov2021 {

    public boolean[] subSuma0MaxElem(int[] v){
        boolean[] solucion = new boolean[v.length];
        boolean[] bestSolucion = new boolean[v.length];
        for (int i = 0 ; i < v.length ; i++) { // Inicializamos la solución
            solucion[i] = false;
            bestSolucion[i] = false;
        }
        int numElem = 0, acumula = 0, nivel = 0;
        Entero bestNumElem = new Entero(0);
        sS0MER(v, solucion, bestSolucion, numElem, acumula, nivel, bestNumElem);
        return bestSolucion;
    }
    private void sS0MER(int[] v, boolean[] solucion, boolean[] bestSolucion, int numElem, int acum, int nivel, Entero bestNumElem){
        if(nivel == v.length){
            if((acum == 0) && (numElem > bestNumElem.getValor())){
                bestNumElem.setValor(numElem);
                System.arraycopy(solucion, 0, bestSolucion, 0, v.length);
            }
        } else {
            for(int c = 0 ; c < 2 ; c++){
                solucion[nivel] = (c==1);
                acum += v[nivel]*c;
                numElem += c;
                sS0MER(v, solucion, bestSolucion, numElem, acum, nivel+1, bestNumElem);
                numElem -= c;
                acum -= v[nivel]*c;
                solucion[nivel] = false;
            }
        }
    }
}
