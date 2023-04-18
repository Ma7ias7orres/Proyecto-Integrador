package org.example;

public class Ronda {
    private String string;
    private Partido[] vectorPartidos;
    private int i;

    public Ronda() {
    }

    public Ronda(String string, Partido[] vectorPartidos, int i) {
        this.string = string;
        this.vectorPartidos = vectorPartidos;
        this.i = i;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Partido[] getVectorPartidos() {
        return vectorPartidos;
    }

    public void setVectorPartidos(Partido[] vectorPartidos) {
        this.vectorPartidos = vectorPartidos;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

