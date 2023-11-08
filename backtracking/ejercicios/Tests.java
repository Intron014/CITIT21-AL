package backtracking.ejercicios;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class Tests {

    @org.junit.jupiter.api.Test
    void prob1_4() {
        prob1_4 test1 = new prob1_4();
        int[] array = {1, 3, 2, 5, 1, 4, 2, 1};
        int pMax = 10;
        int[] ans = {1, 1, 1, 2, 1, 2, 1, 1};
        assertArrayEquals(ans, test1.distribucionCarga2(array, pMax));
    }

    @org.junit.jupiter.api.Test
    void prob1_3() {
        prob1_3 test2 = new prob1_3();
        int[] comienzo = {5, 2, 4, 2, 6, 0, 6, 2};
        int[] fin = {9, 4, 5, 5, 7, 3, 8, 5};
        boolean[] ans = {true, false, true, false, false, true, false, false};
        assertArrayEquals(ans, test2.maxUsoRecurso(comienzo, fin));
    }
}