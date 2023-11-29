package TheOtherClasses.Voraces.jul2022;

public class Concursante {
    //Ci = {identificador, edad, peso, sexo}
    private int id;
    private int edad; //{(1)joven<30; (2)adulto<45; (3)senior<60; (4)anciano≥ 60}
    private int peso; //{(1)pesado:p≥75kg; (2)medio:63<p<75 kg; (3)ligero:p<63 kg}
    private boolean genero; // true = femenino, false = masculine

    public Concursante(int id, int edad, int peso, boolean genero) {
        this.id = id;
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;
    }
    public double fuerzaConcursante() {
        double fuerza = 0;
        if (this.genero)
            fuerza = (double) 1 / this.edad * 1 / this.peso;
        else
            fuerza = (double) 1 / this.edad * 1 / this.peso * 1.3;
        return fuerza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
}