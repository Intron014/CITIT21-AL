package backtracking.ejercicios;

import java.util.Arrays;

public class main {
    public static void main(String[] args){
        prob1_4 test = new prob1_4();
        int[] array = {1, 3, 2, 5, 1, 4, 2, 1};
        int pMax = 10;
        System.out.println(Arrays.toString(test.distribucionCarga2(array, pMax)));

        prob1_3 test3 = new prob1_3();
        int[] comienzo = {5, 2, 4, 2, 6, 0, 6, 2};
        int[] fin = {9, 4, 5, 5, 7, 3, 8, 5};
        System.out.println(Arrays.toString(test3.maxUsoRecurso(comienzo, fin)));

        int[] arrayx = {4, 2, 5, 5, 1, 8};
        prob1_2 test2 = new prob1_2();
        System.out.println(test2.dosSubconjuntos(arrayx, 10));
    }
}
