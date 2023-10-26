public class Backtracking {
    int[] problema2undescore4mine(int[] pesos, int pMax, int[] pesosMochilas, int nivel, int[] mejorSolucion, int mejorDiferencia, Booleano exito) {
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
                    problema2undescore4mine(pesos, pMax, pesosMochilas, nivel, mejorSolucion, mejorDiferencia, exito);
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

    boolean noColision(int c, int[] ori, int[] fin, boolean[] s){
        Booleano ok = new Booleano(true);
        int i = 0;
        while(ok.getValor() && i<c){
            if(s[i]){
                if((fin[c]<=ori[c]) || (fin[i]<=ori[c])){
                    ok.setValor(true);
                } else {
                    ok.setValor(false);
                }
                i++;
            }
        }
        return ok.getValor();
    }
    void problema2underscore3(int[] ori, int[] fin, int id, int dur, boolean[] s, Integer mejorValor, boolean[] mejorSolucion){
        if(mejorValor.getValor()<dur) {
            mejorValor.setValor(dur);
            for (int i = 0; i < s.length; i++) {
                mejorSolucion[i] = s[i];
            }
        }
        for(int c = id; c<s.length; c++){
            if(noColision(c,ori, fin, s)){
                s[c] = true;
                dur+=(fin[c] - ori[c]);
                problema2underscore3(ori, fin, c+1, dur, s, mejorValor, mejorSolucion);
                dur-=(fin[c] - ori[c]);
                s[c]=false;
            }
        }
    }
    void problema2underscore4(int[] peso, int pMax, int id, int p1, int p2, int[] s, Integer mejorValor, int[] mejorSol){
        // I'm dying here and I don't know what to do. Do I feel stupid for thinking I could make it here?
        // Yeah, very much so. How foolish of me. Anyways, this cake is great, it's so delicious and moist.
        // Anyways... [REDACTED]
        // - Jorge Benjumea - Estudiante de la ETSISI, 2023.

        if(p2<=pMax){
            if(mejorValor.getValor() > Math.abs(p1-p2)){
                mejorValor.setValor(Math.abs(p1-p2));
                for(int i=0;i<peso.length;i++){
                    mejorSol[i]=s[i];
                }
            }
        }
        for(int c = id; c<s.length; c++){
            if(peso[c] + p1 <= pMax){
                s[c]=1;
                p1+=peso[c];
                p2-=peso[c];
                problema2underscore4(peso, pMax, c+1, p1, p2, s, mejorValor, mejorSol);
                p2+=peso[c];
                p1-=peso[c];
                s[c]=2;
            }
        }
    }
};
