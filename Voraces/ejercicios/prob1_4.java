package Voraces.ejercicios;

import java.util.ArrayList;

public class prob1_4 {

    public ArrayList<Contenedor> rescate (ArrayList<Contenedor> contenedores, int hundir){
        Contenedor c = null;
        ArrayList<Contenedor> solucion = new ArrayList<Contenedor>();
        while(hundir>0 && !contenedores.isEmpty()){
            c = seleccionarContenedor(contenedores);
            contenedores.remove(c);
            if(hundir-c.getTiempo()>=0){
                solucion.add(c);
                hundir -= c.getTiempo();
            }
        }
        if(solucion.isEmpty())
            return null;
        else
            return solucion;
    }
    private Contenedor seleccionarContenedor (ArrayList<Contenedor> contenedores){
        Contenedor mejor = null;
        for(Contenedor cont : contenedores){
            if(mejor==null || (cont.getBeneficio() > mejor.getBeneficio())){
                mejor = cont;
            }
        }
        return mejor;
    }


    // Clases Requeridas
    class Contenedor{
        private int tiempo; // tiempo en minutos que se tarda en recuperar el contenedor
        private int dias; //número de días que proporciona alimento
        public Contenedor(int tiempo, int dias){
            this.tiempo = tiempo;
            this.dias = dias;
        }

        public int getTiempo() {
            return tiempo;
        }

        public void setTiempo(int tiempo) {
            this.tiempo = tiempo;
        }

        public int getDias() {
            return dias;
        }

        public void setDias(int dias) {
            this.dias = dias;
        }

        public double getBeneficio() {
            return (double) dias /tiempo;
        }
    }
}
