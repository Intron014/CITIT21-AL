package T4ProgramacionDinamica.exams;

public class jan2021 {

    /**
     * Cuenta Herodoto, que el gran rey persa, Darío I, un día cazaba y se torció
     * el tobillo. Aunque todos los médicos de la corte eran reputados egipcios, ninguno de
     * ellos podía aliviar el dolor de su rey y sus consecuentes chillidos. Exhausto y harto de
     * ellos, Darío recurrió a Democedes de Crotona, el más sabio médico griego, quien al
     * poco tiempo de llegar, calma su dolor y cura su torcedura. Darío le colma de oro y de
     * innumerables riquezas, pero, por mantener sus servicios le prohíbe regresar a su
     * hogar como era su máximo deseo. Democedes, ante semejante situación, no tarda en
     * urdir un ingenioso plan. Para llevarlo a cabo necesitará llevar, sin superar un cierto
     * peso, la máxima cantidad de dinero posible para hacer uso de él en sobornos y
     * alojamientos. Por cada tipo de moneda del sistema monetario persa, Democedes
     * cuenta con ilimitada cantidad de monedas debido a la recompensa recibida. Le
     * gustaría saber la cantidad de monedas de cada tipo que debe llevar para conseguir el
     * máximo valor sin que se supere un peso máximo que él ha establecido.
     */

    public int[] mejorSeleccion(int[] pesos, int[] valores, int maxPeso){
        int[][] maxValue = new int[2][maxPeso + 1];
        boolean [][] aux = new boolean[valores.length][maxPeso + 1];
        for (int p = 0 ; p <= maxPeso ; p++){
            aux[0][p] = (pesos[0]<=p);
            if(pesos[0] <= p){
                maxValue[0][p] = valores[0] + maxValue[0][p - pesos[0]];
            } else {
                maxValue[0][p] = 0;
            }
        }
        for (int i = 1 ; i < valores.length ; i++){
            for (int p = 0 ; p <= maxPeso ; p++){
                if(pesos[i] > p){
                    maxValue[i % 2][p] = maxValue[(i-1) % 2][p];
                } else {
                    maxValue[i % 2][p] = Math.max(maxValue[(i - 1) % 2][p], valores[i] + maxValue[i % 2][p - pesos[i]]);
                    aux[i][p] = !(maxValue[i % 2][p] == maxValue[(i - 1) % 2][p]);
                }
            }
        }
        return monedasSeleccionadas(aux, pesos, valores);
    }

    private int[] monedasSeleccionadas(boolean[][] aux, int[] pesos, int[] valores){
        int i=valores.length-1; int p=aux[0].length-1;
        int[] decision = new int[valores.length];
        decision[i]=0;
        while (i >= 0) {
            if (aux[i][p]) {
                p = p - pesos[i]; decision[i]++;
            } else {
                i--;
                if (i >= 0) decision[i]=0;
            }
        }
        return decision;
    }

}
