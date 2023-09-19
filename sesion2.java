import java.lang.reflect.Array;
import java.util.Arrays;

public class sesion2 {

    public static void main(String[] args) {
        int[] array = new int[] {12, 3, -2, 1, 7, 8, -31};
        System.out.println(array.length);
        combSort(array);
        System.out.println(Arrays.toString(array));
    }
    static int[] algoritmoPorSeleccion(int[] array){ //No es estable
        //TODO: Arreglar
        return array;
    }
    static int[] algoritmoPorInsercion(int[] array){ //Estable
        //TODO: Arreglar
        return array;
    }
    static int[] algoritmoPorBurbuja(int[] array) { //Estable
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
        return array;
    }
    static int[] combSort(int[] array) { //No es estable
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
        return array;
    }

}
