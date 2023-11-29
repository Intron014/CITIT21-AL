package TheOtherClasses.Voraces.jul2021;

public class Partido {
    private String nombre;
    private int diputados;
    private float orientacion;
    public Partido(String nombre, int diputados, float orientacion){
        this.nombre = nombre;
        this.diputados = diputados;
        this.orientacion = orientacion;
    }
    public float Perjuicio(Partido p2){
        return (Math.abs(this.getOrientacion()-p2.getOrientacion()) / 9);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiputados() {
        return diputados;
    }

    public void setDiputados(int diputados) {
        this.diputados = diputados;
    }

    public float getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(float orientacion) {
        this.orientacion = orientacion;
    }
}