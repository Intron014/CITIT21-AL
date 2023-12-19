package T4ProgramacionDinamica.exams;

public class dec2017 {

    /**
     * Batman y Wonder Woman son grandes aficionados al
     * juego de los dardos. El tablero con el que habitualmente
     * juegan está dividido en secciones, cada una de ellas con un
     * valor numérico concreto, tal y como se muestra en la figura.
     * Wonder Woman le plantea a Batman el reto de conseguir
     * una puntuación concreta P, usando el menor número de
     * dardos. Dado que a Batman no se le dan bien los problemas
     * de optimización, pide ayuda a los alumnos de Algorítmica de
     * la ETSISI para que le diseñen e implementen un algoritmo
     * con la siguiente cabecera int[] numDardos(int[] secciones, int P), que le indique a qué
     * secciones del tablero debe tirar los dardos para conseguir obtener la puntuación P
     * minimizando el número de dardos usados (considerar que Batman es un gran jugador de
     * dardos y todos los dardos que tira quedan situados en alguna sección del tablero
     * puntuable).
     */

    public int[] numDardos(int[] secciones, int P){
        int[][] cant = new int[2][P+1];
        boolean[][] aux = new boolean[secciones.length+1][P+1];
        for (int c=0;c<=P; c++) {
            cant[0][c] = Integer.MAX_VALUE; aux[0][c]= false;
        }
        cant[0][0] = 0; cant[1][0] = 0;
        for (int i=0;i<= secciones.length; i++)
            aux[i][0] = false;
        for (int i=1; i<= secciones.length; i++) {
            for (int c=1; c<=P; c++)
                if (c< secciones [i-1]) {
                    cant[i%2][c]=cant[(i-1)%2][c];
                    aux[i][c]=false;}
                else {
                    cant[i%2][c]=Math.min(cant[(i-1)%2][c],
                            1+cant[i%2][c- secciones [i-1]]);
                    aux[i][c]=(cant[i%2][c]==1+cant[i%2][c- secciones [i-1]]);}
        }
        return cantidadDardos(aux, secciones);
    }

    private int[] cantidadDardos(boolean[][] aux, int[] secciones){
        int i=aux.length-1; int c=aux[0].length-1;
        int[] decision = new int[aux.length-1];
        decision[i-1]=0;
        while (c>0 && i>0) {
            if (aux[i][c]==true) {
                c=c- secciones [i-1]; decision[i-1]++; }
            else {
                i--; decision[i-1]=0;}
        }
        return decision;
    }
}
