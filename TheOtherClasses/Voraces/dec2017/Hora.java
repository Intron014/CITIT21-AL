package TheOtherClasses.Voraces.dec2017;

public class Hora {
    private int hora;
    private int minutos;
    public Hora(int hora, int minutos){
        this.hora=hora;
        this.minutos=minutos;
    }
    public int transformaAMinutos(){
        return ((this.hora*60)+(this.minutos));
    }
}