package com.example.incluyeme;

import java.io.Serializable;

public class Nota implements Serializable {
    public int id;
    String curso;
    String tipoEvaluacion; //Examen Final, Examen Parcial, etc.
    int peso; //peso en porcentajes (20% del total, 40% del total, etc.)
    int puntaje;

    public Nota(int id, String curso, String tipoEvaluacion, int peso, int puntaje) {
        this.id=id;
        this.curso = curso;
        this.tipoEvaluacion = tipoEvaluacion;
        this.peso = peso;
        this.puntaje=puntaje;
    }
}
