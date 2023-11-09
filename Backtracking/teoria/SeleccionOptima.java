package Backtracking.teoria;
import TheOtherClasses.*;
public class SeleccionOptima {
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
    void problema2underscore3(int[] ori, int[] fin, int id, int dur, boolean[] s, Entero mejorValor, boolean[] mejorSolucion){
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
    void problema2underscore4(int[] peso, int pMax, int id, int p1, int p2, int[] s, Entero mejorValor, int[] mejorSol){
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

    public static void main(String[] args){
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int n = 5;
        int[] array = {8,15,10,20,8};
        int kobj = 2;
        System.out.println();
        SeleccionOptima bt = new SeleccionOptima();
        System.out.println(bt.dC(array, kobj));
        System.out.println(bt.maximumRequests(n, requests));
    }
    //https://leetcode.com/problems/fair-distribution-of-cookies/
    private void dCR(int[] cookies, int lvl, Entero bestvalue, int[] mejorsoluc, int k, int[] tsol) {
        if(lvl == cookies.length){
            int max = 0;
            for(int i = 0; i < k; i++){
                if(tsol[i] > max){
                    max = tsol[i];
                }
            }
            if(max < bestvalue.getValor()){
                bestvalue.setValor(max);
                for(int i = 0; i < k; i++){
                    mejorsoluc[i] = tsol[i];
                }
            }
        }
        else{
            for(int i = 0; i < k; i++){
                tsol[i] += cookies[lvl];
                dCR(cookies, lvl+1, bestvalue, mejorsoluc, k, tsol);
                tsol[i] -= cookies[lvl];
            }
        }
    }
    public int dC(int[] cookies, int k){
        int[] tsol = new int[k];
        int[] mejorsoluc = new int[k];
        Entero bestvalue = new Entero(Integer.MAX_VALUE);
        dCR(cookies, 0, bestvalue, mejorsoluc, k, tsol);
        return bestvalue.getValor();
    }

    //https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
    //We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season,
    //and some employees want to change the building they reside in.
    //
    //You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer
    //from building fromi to building toi.
    //
    //All buildings are full, so a list of requests is achievable only if for each building, the net change in employee
    //transfers is zero. This means the number of employees leaving is equal to the number of employees moving in.
    //For example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving
    //building 2, there should be two employees moving to building 0, one employee moving to building 1,
    //and one employee moving to building 2.
    //
    //Return the maximum number of achievable requests.
    public int maximumRequests(int n, int[][] requests) {
        int[] tsol = new int[n];
        Entero bestvalue = new Entero(Integer.MAX_VALUE);
        mRR(n, requests, 0, tsol, bestvalue);
        return bestvalue.getValor();
    }

    private void mRR(int n, int[][] requests, int lvl, int[] tsol, Entero bestvalue){
        if(lvl == requests.length){
            int max = 0;
            for(int i = 0; i < n; i++){
                if(tsol[i] > max){
                    max = tsol[i];
                }
            }
            if(max < bestvalue.getValor()){
                bestvalue.setValor(max);
            }
        }
        else{
            tsol[requests[lvl][0]]--;
            tsol[requests[lvl][1]]++;
            mRR(n, requests, lvl+1, tsol, bestvalue);
            tsol[requests[lvl][0]]++;
            tsol[requests[lvl][1]]--;
            mRR(n, requests, lvl+1, tsol, bestvalue);
        }
    }

};
