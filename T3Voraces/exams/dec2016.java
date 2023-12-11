package T3Voraces.exams;

import java.util.ArrayList;

public class dec2016 {


    /**
     * Diseñar e implementar el método boolean hayDivision(int[] valores)
     * en Java basado en el esquema voraz, que permita determinar si, dado un
     * conjunto de números enteros positivos mayores que 0, existen dos subconjuntos
     * que sumen exactamente el mismo valor, y que cada uno contenga la mitad de los
     * números del vector valores
     */


    public boolean hayDivision(int[] valores){
        if(valores.length%2!=0)
            return false;
        else {
            ArrayList<Integer> valores2 = new ArrayList<>(valores.length);
            for (int i : valores) {
                valores2.add(i);
            }
            int[] totalA_B = {0, 0};
            int[] cantidadA_B = {0, 0};
            int c;
            while(!valores2.isEmpty()){
                c = seleccionarCandidato(valores2);
                valores2.remove(c);
                if(totalA_B[0] < totalA_B[1]){
                    totalA_B[0] += c;
                    cantidadA_B[0]++;
                } else {
                    totalA_B[1] += c;
                    cantidadA_B[1]++;
                }
            }
            return ((totalA_B[0] == totalA_B[1]) && (cantidadA_B[0] == cantidadA_B[1]));
        }
    }

    private int seleccionarCandidato(ArrayList<Integer> candidatos){
        int c = candidatos.get(0);
        for(int i = 1 ; i < candidatos.size() ; i++){
            if(c < candidatos.get(i))
                c = candidatos.get(i);
        }
        return c;
    }
}
