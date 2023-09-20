import java.lang.reflect.Array;
import java.util.Arrays;

public class sesion2 {

    public static void main(String[] args) {
        int[] array = new int[] {12, 3, -2, 1, 7, 8, -31, 43};
        algoritmoPorSeleccion(array);
        algoritmoPorInsercion(array);
        combSort(array);
        algoritmoPorBurbuja(array);
    }
    static void algoritmoPorSeleccion(int[] array){ //No es estable
        int a;
        int b;
        int c;
        for(a = 0 ; a < array.length - 1 ; a ++){
            c = a;
            for(b = a + 1 ; b < array.length ; b ++){
                if(array[b] < array[c]){
                    c = b;
                }
            }
            int aux = array[a];
            array[a] = array[c];
            array[c] = aux;
        }
        System.out.println(Arrays.toString(array));
    }
    static void algoritmoPorInsercion(int[] array){ //Estable
        for(int a = 0 ; a < array.length - 1 ; a ++){
            for(int b = array.length - 1 ; b > a ; b --){
                if(array[a]>array[b]){
                    int aux = array[a];
                    array[a] = array[b];
                    array[b] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    static void algoritmoPorBurbuja(int[] array) { //Estable
        int a;
        int cnt;
        for(cnt = 0; cnt < array.length - 1; cnt++){
            for(a=1 ; a < array.length ; a++) {
                if (array[a - 1] > array[a]) {
                    int aux = array[a - 1];
                    array[a - 1] = array[a];
                    array[a] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    static void combSort(int[] array) { //No es estable
        int gap = array.length - 1;
        int a;
        for(;gap>0;gap--){
            for(a=0 ; a+gap < array.length ; a++) {
                if (array[a + gap] < array[a]) {
                    int aux = array[a + gap];
                    array[a + gap] = array[a];
                    array[a] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
