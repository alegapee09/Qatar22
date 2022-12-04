package datos;

public class Resultado {
    private String fase;
    private String fecha;
    private String primerequipo;
    private int golesprimer;
    private String segundoequipo;
    private int golesseg;

    public Resultado(String fase, String fecha, String primerequipo, int golesprimer, String segundoequipo, int golesseg) {
        this.fase = fase;
        this.fecha = fecha;
        this.primerequipo = primerequipo;
        this.golesprimer = golesprimer;
        this.segundoequipo = segundoequipo;
        this.golesseg = golesseg;
    }

    @Override
    public String toString() {
        return "Resultados: " +
                "Fase = " + fase + '\'' +
                ", Fecha = " + fecha + '\'' +
                ", Equipo 1='" + primerequipo + '\'' +
                ", Goles Equipo 1 = " + golesseg +
                ", Equipo 2 = '" + segundoequipo + '\'' +
                ", Goles Equipo 2 = " + golesseg;
    }

    public String getPrimerequipo() {
        return primerequipo;
    }

    public String getSegundoequipo() {
        return segundoequipo;
    }


}