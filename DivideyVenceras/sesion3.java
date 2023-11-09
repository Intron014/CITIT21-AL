package DivideyVenceras;

public class sesion3 {
    public static void main(String[] args) {
        int[] arraya = {12,3,4,-21,8,10,5,6,1};
        int[] arrayb = {-2,3,6,2};

        sesion3 sesion = new sesion3();
        sesion.mergeTwoArrays(arraya, arrayb);

    }

    public int[] mergeTwoArrays(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int cnt=0;
        int i, j;
        
        for(i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
        return c;
    }
}
