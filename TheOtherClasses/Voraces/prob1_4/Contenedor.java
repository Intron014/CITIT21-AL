package TheOtherClasses.Voraces.prob1_4;

public class Contenedor{
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

    public float getBeneficio() {
        return ((float) this.dias) / ((float) this.tiempo);
    }
}