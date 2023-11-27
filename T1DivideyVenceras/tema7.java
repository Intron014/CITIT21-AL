package T1DivideyVenceras;

public class tema7 {

    public static void main(String[] args){
        int[] patata = new int[] {1,4,6,2};
        System.out.println(maxArrayInPos(patata, 2));
    }
    public static int maxArrayInPos(int[] v, int k){
        int max = Integer.MIN_VALUE;
        int l = v.length;
        for(int i=0; i<v.length && l > k; i++){
            if(v[i] > max){
                max = v[i];
                i=0; l--;
            }
        }
        return max;
    }
    private static int k_esimoValorR(int[] v, int i0, int iN, int k){
        if(i0 == iN) {
            return v[i0];
        } else{
            int m = ordenarPorPivote(v, i0, iN);
            if(k<=iN-m){
                return k_esimoValorR(v, m+1, iN, k);
            }
            else if (k==iN-m+1){
                return v[m];
            }
            else{
                return k_esimoValorR(v, i0, m-1, k-(iN-m+1));
            }
        }
    }
    public static int k_esimoValor(int[] v, int k){
        return k_esimoValorR(v, 0, v.length-1, k);
    }
    public static int ordenarPorPivote(int[] v, int i0, int iN){
        return 1;
    }
}
