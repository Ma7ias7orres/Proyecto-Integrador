package org.example;

public class Persona {
    private String nombre;
    private Pronostico [] prodePersona;
    public Persona() {    }
    public Persona(String nombre, Pronostico[] prodePersona) {
        this.nombre = nombre;
        this.prodePersona = prodePersona;
    }    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pronostico[] getProdePersona() {
        return prodePersona;
    }
    public void setProdePersona(Pronostico[] prodePersona) {
        this.prodePersona = prodePersona;
    }
    public int puntaje() {
        int totalPuntos = 0;
        for(Pronostico pronostico : prodePersona) {
            totalPuntos+= pronostico.puntos();
        }
        return totalPuntos;
    }
}
