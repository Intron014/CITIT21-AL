package T4ProgramacionDinamica.ejercicios;

public class prob1_4 {

    /**
     * La compañía “Geneticáte SA” está especializada en la síntesis de secuencias
     * de ADN1. La compañía sintetiza una secuencia de ADN a partir de otra a través de las
     * siguientes operaciones (cada una de ellas con un coste asociado):
     * • Introduciendo un nucleótido. Esta modificación tiene un coste a.
     * • Borrando un nucleótido. Esta modificación tiene un coste b.
     * • Mutando un nucleótido de tipo i por otro de tipo j. Esta modificación tiene
     * un coste mij. Por ejemplo mAT representa el coste de mutar una Adenina por
     * una Timina
     * La compañía nos pide diseñar un algoritmo que calcule el mínimo coste que supone
     * sintetizar una secuencia de ADN a partir de otra (teniendo en cuenta los valores a, b,
     * mij).
     */

    public int coste(int[] adn1, int[] adn2, int a, int b, int[][] m){
        int long1 = adn1.length;
        int long2 = adn2.length;
        if(long2<long1){
            int[][] c = new int[2][long2+1];
            for(int j=0 ; j<=long2 ; j++) //Coste de añadir nucleótido
                c[0][j]=j*a;
            for(int i=1 ; i<=long1 ; i++){ //Coste de borrar nucleótido
                c[i%2][0]=i*b;
                for (int j=1; j<=long2; j++) //Coste de mutar nucleótidos
                    c[i%2][j]= Math.min(m[adn1[i-1]][adn2[j-1]]+c[(i-1)%2][j-1], Math.min(a+c[i%2][j-1],b+c[(i-1)%2][j]));
            }
            return c[long1%2][long2];
        }
        else{
            int[][] c= new int[long1+1][2];
            for (int i=0; i<=long1; i++) //Coste de borrar nucleótidos
                c[i][0]=i*b;
            for (int j=1; j<=long2; j++) { //Coste de añadir nucleótidos
                c[0][j%2]=j*a;
                for (int i=1; i<=long1; i++) //Coste de mutar nucleótidos
                    c[i][j%2]=Math.min(m[adn1[i-1]][adn2[j-1]]+c[i-1][(j-1)%2],
                            Math.min(a+c[i][(j-1)%2],b+c[i-1][j%2]));
            }
            return c[long1][long2%2];
        }
    }
}
