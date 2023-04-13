package modelo;
public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private String participante;
    public Pronostico() {
    }
    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado,String participante) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.participante=participante;
    }
    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public int puntos (){
        if(partido.resultado(equipo) == resultado) {
            return 1;  //Si el resultado pronosticado del equipo es igual al resultado del equipo suma un punto
        } else {
            return 0; //Si es diferente no suma nada
        }
    }
}
