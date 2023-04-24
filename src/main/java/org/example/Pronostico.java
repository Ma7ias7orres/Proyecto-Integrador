package org.example;

import java.util.Scanner;


public class Pronostico {
    private static final int alo = valoracierto();
	private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private Persona participante;
    
    
    
    public Pronostico() {
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado, Persona participante) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.participante = participante;
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

    public Persona getParticipante() {
        return participante;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }

    
    public static int valoracierto() {					//pedimos por teclado el valor de cada acierto
    	
    	System.out.print("Ingrese valor por acierto: ");
    	int ind = new Scanner(System.in).nextInt();
    	
    	return ind;
    }
    
    public int puntos (){
    	    	
    	
        	if(partido.resultado(equipo) == resultado) {
            return alo;  //Si el resultado pronosticado del equipo es igual al resultado del equipo suma un punto
        } else {
            return 0; //Si es diferente no suma nada
        }
    }
    
    
    
    
    
    
    
}
