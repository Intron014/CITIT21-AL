package T4ProgramacionDinamica.ejercicios;

public class prob1_3 {

    /**
     * La empresa Olive.S.A produce y distribuye aceite de oliva a domicilio. Con
     * el tiempo la empresa se ha hecho con una larga lista de clientes y necesitan un nuevo
     * programa informático para decidir a qué clientes vender y distribuir con el objetivo
     * de maximizar sus beneficios. A diario la empresa dispone de un depósito de T litros
     * de aceite para vender y distribuir, y de una lista de clientes que incluye la siguiente
     * información: los litros de aceite que solicita (litros), el precio al que paga el litro
     * (precioLitro) y el gasto que le supone a la empresa distribuir el producto al cliente
     * (gasto), entre otras razones debido al precio de la gasolina y la distancia que debe
     * recorrer para la entrega.
     */

    public int maximoBeneficio(int[] litros, int[] precioLitro, int[] gasto, int T){
        int[][] maxBenef = new int[litros.length][T+1];
        for(int x=0 ; x<=T ; x++) {
            if (litros[0] > x)
                maxBenef[0][x] = 0;
            else maxBenef[0][x] = (litros[0]*precioLitro[0])-gasto[0];
        }
        for(int i=0 ; i < litros.length ; i++){
            for (int x = 0 ; x<=T ; x++){
                if(litros[i]>x){
                    maxBenef[i][x] = maxBenef[i-1][x];
                } else {
                    maxBenef[i][x] = Math.max(maxBenef[i-1][x], ((litros[i]*precioLitro[i])-gasto[i]) + maxBenef[i-1][x-litros[i]]);
                }
            }
        }
        return maxBenef[litros.length-1][T];
    }

}
