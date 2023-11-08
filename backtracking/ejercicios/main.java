package backtracking.ejercicios;

import java.util.Arrays;

public class main {
    public static void main(String[] args){
        prob1_4 test = new prob1_4();
        int[] array = {1, 3, 2, 5, 1, 4, 2, 1};
        int pMax = 10;
        System.out.println(Arrays.toString(test.distribucionCarga2(array, pMax)));
    }
}
