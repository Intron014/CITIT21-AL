public class sesion1 {
    // Ejercicio 1.1
    static int maxEnArray(int[] array) {
        int max = array[0];
        for (int pos = 1; pos < array.length; pos++) {
            if (max < array[pos]){
                max = array[pos];
            }
        }
        return max;
    }
// Ejercicio 1.2a
    static boolean isEnArray(int[] array, int search) {
        int pos = 0;
        while(pos < array.length && search < array[pos]) {
            pos++;
        }
        return pos < array.length && array[pos] == search;
    }
// Ejercicio 1.2b
    static boolean busquedaBinaria(int array[], int search) {
        boolean encontrado = false;
        int pos = array.length / 2;
        int diff;
        if (array[pos] == search) {
            encontrado = true;
        } else if (array[pos] < search) {
            encontrado = busquedaBinaria(array[0:pos-1], search);
        }
        return pos < array.length && search == array[pos];
    }
// Ejercicio 1.3a
    static int[][] transMatriz(int[][] matriz) {
        int[][] matTrans = new int[matriz[0].length][matriz.length];
        for(int i=0 ; i < matriz.length ; i++){
            for (int j=0 ; j < matriz[0].length ; j++){
                matTrans[j][i] = matriz[i][j];
            }
        }
        return matTrans;
    }
// Ejercicio 1.3b
    static int[][] trnasSquare(int[][] matriz) {
        int aux;

        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = i + 1; j < matriz.length; j++) {
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
            }
        }
        return matriz;
    }
}