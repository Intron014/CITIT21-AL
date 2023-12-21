package T4ProgramacionDinamica.ejercicios;

public class prob1_1 {

    /**
     * Diseña e implementa el método public boolean haySuma(int[] valores, int v) en Java
     * basado en el esquema de programación dinámica, que permita determinar si, dado
     * un conjunto de números enteros positivos mayores que 0, existe un subconjunto
     * que sume el valor V. Por ejemplo, dado el vector valores = {5, 8, 7, 1, 3, 1} y el valor
     * v=10, el algoritmo debería devolver true; dado el vector valores = {5, 8, 7, 2, 3} y el
     * valor v=21, el algoritmo debería devolver false
     */

    public boolean haySuma(int[] valores, int v){
        boolean[][] lahayquestionmark = new boolean[v+1][valores.length];
        lahayquestionmark[0][0] = true;
        for (int i=1; i<=v; i++) lahayquestionmark[i][0]= (valores[0]==i);

        for (int j=1 ; j<valores.length ; j++){
            for (int i=0 ; i<=v ; i++){
                if(lahayquestionmark[i][j-1]) lahayquestionmark[i][j]=true;
                else if (j<=i && lahayquestionmark[i-valores[j]][j-1]) lahayquestionmark[i][j]=true;
                else lahayquestionmark[i][j]=false;
            }
        }

        return lahayquestionmark[v][valores.length-1];
    }

}
