package Backtracking.ejercicios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void prob1_4() {
        prob1_4 test = new prob1_4();
        int[] array = {1, 3, 2, 5, 1, 4, 2, 1};
        int pMax = 10;
        int[] ans = {1, 1, 1, 2, 1, 2, 1, 1};
        assertArrayEquals(ans, test.distribucionCarga2(array, pMax));
    }

    @Test
    void prob1_3() {
        prob1_3 test = new prob1_3();
        int[] comienzo = {5, 2, 4, 2, 6, 0, 6, 2};
        int[] fin = {9, 4, 5, 5, 7, 3, 8, 5};
        boolean[] ans = {true, false, true, false, false, true, false, false};
        assertArrayEquals(ans, test.maxUsoRecurso(comienzo, fin));
    }

    @Test
    void prob1_2() {
        prob1_2 test = new prob1_2();
        int[] array = {4, 2, 5, 5, 1, 8};
        assertTrue(test.dosSubconjuntos(array, 10));
    }
}