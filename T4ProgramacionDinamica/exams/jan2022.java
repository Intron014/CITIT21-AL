package T4ProgramacionDinamica.exams;

public class jan2022 {

    /**
     * Dado un array de números enteros, encontrar la longitud del
     * subarray1 ordenado más largo
     */

    public int longMaxSubarrayOrdenado(int[] vector){
        int max_end = 1;
        int max_tot = 1;
        for ( int i = 1 ; i< vector.length ; i++ ){
            if(vector[i-1] > vector[i]){
                max_end = 1;
            } else {
                max_end = max_end + 1;
            }
            max_tot = Math.max(max_end, max_tot);
        }
        return max_tot;
    }

}
