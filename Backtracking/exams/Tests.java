package Backtracking.exams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void testNov2021(){
        nov2021 exam = new nov2021();
        int[] v = {-4, 3, 5, -5, 0, 1, 8, 10, -21};
        boolean[] r = {false, true, true, true, true, false, true, true, true};
        assertArrayEquals(r, exam.subSuma0MaxElem(v));
    }
}