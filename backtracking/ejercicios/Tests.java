package backtracking.ejercicios;

import java.util.Arrays;

class Tests {

    @org.junit.jupiter.api.Test
    void distribucionCarga2() {
        prob1_4 test1 = new prob1_4();
        int[] array = {1, 3, 2, 5, 1, 4, 2, 1};
        int pMax = 10;
        test1.distribucionCarga2(array, pMax);
    }
}