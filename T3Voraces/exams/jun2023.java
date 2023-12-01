package T3Voraces.exams;

import java.util.ArrayList;

public class jun2023 {

    /*
     Se quiere formar una torre de objetos con los cinco sólidos platónicos(1)
     (tetraedros, hexaedros (cubos), octaedros, dodecaedros e icosaedros) que en total
     sumarán N caras. Por ejemplo, una torre formada por tres solidos: [1 icosaedro, 1
     dodecaedro, 1 tetraedro] sumaría un total de 36 caras. Para formar una torre válida, la
     base y los elementos intermedios deben poder sostenerse sobre una cara superior y otra
     inferior, es decir un sólido no puede apoyarse sobre una arista. Es por ello que en una
     torre válida el tetraedro solo podrá estar en la cima y sólo podrá haber 1 como máximo.
     */

    public int[] greedyTower (int v){
        int[] faces = {6, 8, 12, 20};
        int[] solucion = new int[faces.length + 1];
        int sumRestantes = v;
        int i = 0;
        while(sumRestantes > 0 && i < faces.length){
            if(sumRestantes >= faces[i]){
                solucion[i] = sumRestantes/faces[i];
                sumRestantes = sumRestantes%faces[i];
            }
            i++;
        }
        if(sumRestantes == 4){
            solucion[0] = 1;
            sumRestantes = 0;
        }
        if(sumRestantes == 0){
            return solucion;
        } else
            return null;
    }


}
