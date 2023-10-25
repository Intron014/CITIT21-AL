public class Backtracking {
    private int[] distribucionCarga2(int[] pesos, int pMax, int[] pesosMochilas, int nivel, int[] mejorSolucion, int mejorDiferencia, Booleano exito) {
        if (nivel == pesos.length - 1) {
            int[] solucion = new int[pesos.length];
            for (int i = 0; i < pesos.length; i++) {
                solucion[i] = pesosMochilas[i];
            }
            int diferencia = Math.abs(pesosMochilas[0] - pesosMochilas[1]);
            if (diferencia < mejorDiferencia) {
                mejorDiferencia = diferencia;
                for (int i = 0; i < pesos.length; i++) {
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {
            int c = 0;
            while (!exito.getValor() && c < pesosMochilas.length) {
                if (pesosMochilas[c] + pesos[nivel] <= pMax) {
                    pesosMochilas[c] = pesosMochilas[c] + pesos[nivel];
                    nivel += 1;
                    distribucionCarga2(pesos, pMax, pesosMochilas, nivel, mejorSolucion, mejorDiferencia, exito);
                    if (!exito.getValor()) {
                        nivel -= 1;
                        pesosMochilas[c] = pesosMochilas[c] - pesos[nivel];
                    }
                    c++;
                }
                c--;
            }
        }
        return mejorSolucion;
    };

    private int[] disCarg2Backtracking(int[] pesos, int pMax) {
        int[] pesosMochilas = new int[pesos.length];
        int[] mejorSolucion = new int[pesos.length];
        int mejorDiferencia = Integer.MAX_VALUE;
        Booleano exito = new Booleano(false);
        return distribucionCarga2(pesos, pMax, pesosMochilas, 0, mejorSolucion, mejorDiferencia, exito);
    };
};
