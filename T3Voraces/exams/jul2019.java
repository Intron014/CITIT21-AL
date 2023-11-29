package T3Voraces.exams;

public class jul2019 {

    /*
     Nos dan un vector de N números enteros, y un número K. Podemos
     transformar el vector multiplicando por -1 uno de sus elementos. Deseamos
     transformar el vector K veces exactas de manera que la suma de sus elementos
     sea máxima.
     */

    public int[] vectorTransformado(int[] vector, int k){
        int[] solucion = new int[vector.length];
        System.arraycopy(vector, 0, solucion, 0, vector.length);
        for(int i = 0 ; i < k ; i++){
            int pMin = 0;
            for(int j = 0 ; j < solucion.length ; j++){
                if(solucion[j]<solucion[pMin])
                    pMin = j;
            }
            solucion[pMin]=-solucion[pMin];
        }
        return solucion;
    }
}
